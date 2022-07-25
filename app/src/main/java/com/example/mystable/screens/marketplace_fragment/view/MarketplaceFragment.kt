package com.example.mystable.screens.marketplace_fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.mystable.R
import com.example.mystable.databinding.FragmentMarketplaceBinding
import com.example.mystable.model.MarketplaceRepo
import com.example.mystable.network.MarketplaceDataSource
import com.example.mystable.pojo.Category
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModel
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModelFactory


class MarketplaceFragment : Fragment(), MarketplaceCategoriesCallBack {
    private lateinit var binding: FragmentMarketplaceBinding

    private lateinit var viewModel: MarketPlaceViewModel
    private lateinit var viewModelFactory: MarketPlaceViewModelFactory

    private lateinit var tabsAdapter: TabsAdapter
    private lateinit var tabItemsAdapter: TabDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_marketplace,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupListener()
        initObservers()

        viewModel.getCategory(false) // true for getting data - false for getting no data

    }

    private fun init() {
        binding.countryBt.text = "Egypt"  // temp

        tabsAdapter = TabsAdapter(requireContext(), emptyList(), this)
        binding.tabsRecycler.adapter = tabsAdapter
        tabItemsAdapter = TabDetailsAdapter(requireContext(), emptyList())
        binding.tabDetailsRecycler.adapter = tabItemsAdapter

        viewModelFactory = MarketPlaceViewModelFactory(
            MarketplaceRepo(MarketplaceDataSource())
        )

        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketPlaceViewModel::
            class.java]

        binding.swipeCategoryDetail.isEnabled = false
        binding.progressIndicator.visibility = View.VISIBLE
    }

    private fun setupListener() {
        binding.swipeAll.setOnRefreshListener {
            binding.swipeAll.isRefreshing = false
            binding.progressIndicator.visibility = View.VISIBLE
            binding.mainConstraint.visibility = View.INVISIBLE
            binding.placeholderTab.visibility = View.INVISIBLE

            viewModel.getCategory(true)
        }

        binding.swipeCategoryDetail.setOnRefreshListener {
            binding.swipeCategoryDetail.isRefreshing = false
            binding.progressIndicator.visibility = View.VISIBLE
            binding.tabDetailsRecycler.visibility = View.INVISIBLE
            binding.placeholderTabDetails.visibility = View.INVISIBLE

            viewModel.refreshCategoryDetails()
        }
    }

    private fun initObservers() {
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            binding.progressIndicator.visibility = View.INVISIBLE
            if (it.isNullOrEmpty()) {
                binding.swipeAll.visibility = View.VISIBLE
                binding.swipeAll.isEnabled = true
                binding.swipeCategoryDetail.isEnabled = false
                binding.mainConstraint.visibility = View.INVISIBLE
                binding.placeholderTab.visibility = View.VISIBLE
            } else {
                tabsAdapter.setTabsInfo(it)
                binding.swipeAll.isEnabled = false
                binding.swipeCategoryDetail.isEnabled = true
                binding.mainConstraint.visibility = View.VISIBLE
                binding.placeholderTab.visibility = View.INVISIBLE
            }
        }

        viewModel.categoryDetailsLiveData.observe(viewLifecycleOwner) {
            binding.progressIndicator.visibility = View.INVISIBLE
            if (it != null) {
                tabItemsAdapter.setTabDetails(it.categoryDetailsItems)
                binding.tabDetailsRecycler.visibility = View.VISIBLE
                binding.placeholderTabDetails.visibility = View.INVISIBLE
            } else {
                binding.tabDetailsRecycler.visibility = View.INVISIBLE
                binding.placeholderTabDetails.visibility = View.VISIBLE
            }
        }

        viewModel.selectedCategoryLiveData.observe(viewLifecycleOwner) {
            println("Hello Everybody")
        }
    }

    override fun showDataForClickedItem(tab: Category) {
        binding.tabDetailsRecycler.visibility = View.INVISIBLE
        binding.placeholderTabDetails.visibility = View.INVISIBLE
        binding.progressIndicator.visibility = View.VISIBLE
//        tabItemsAdapter.setTabDetails(emptyList())
        viewModel.getCategoryDetails(tab.id)
    }
}