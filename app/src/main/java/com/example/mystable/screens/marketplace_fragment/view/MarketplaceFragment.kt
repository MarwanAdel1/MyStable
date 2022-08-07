package com.example.mystable.screens.marketplace_fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.mystable.R
import com.example.mystable.databinding.FragmentMarketplaceBinding
import com.example.mystable.model.MarketplaceRepo
import com.example.mystable.network.MarketplaceDataSource
import com.example.mystable.pojo.Category
import com.example.mystable.pojo.CategoryDetails
import com.example.mystable.screens.marketplace_fragment.view.adapter.CategoryTabAdapter
import com.example.mystable.screens.marketplace_fragment.view.adapter.CategoryTabItemsAdapter
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModel
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModelFactory


class MarketplaceFragment : Fragment(), MarketplaceCategoriesCallBack,
    MarketplaceCategoryItemsCallback {
    private lateinit var binding: FragmentMarketplaceBinding

    private lateinit var viewModel: MarketPlaceViewModel
    private lateinit var viewModelFactory: MarketPlaceViewModelFactory

    private lateinit var categoryTabAdapter: CategoryTabAdapter
    private lateinit var tabItemsAdapter: CategoryTabItemsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModelFactory = MarketPlaceViewModelFactory(
            MarketplaceRepo(MarketplaceDataSource())
        )

        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketPlaceViewModel::
            class.java]

        viewModel.getAllCategory(false) // true for getting data - false for getting no data
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMarketplaceBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupListener()
        initObservers()
    }

    private fun init() {
        binding.countryBt.text = "Egypt"  // temp

        categoryTabAdapter = CategoryTabAdapter(requireContext(), emptyList(), this)
        binding.tabsRecycler.adapter = categoryTabAdapter
        tabItemsAdapter =
            CategoryTabItemsAdapter(requireContext(), CategoryDetails(-1, emptyList()), this)
        binding.tabDetailsRecycler.adapter = tabItemsAdapter

        disableSwipe()

        binding.progressIndicator.visibility = View.VISIBLE
    }

    private fun disableSwipe() {
        binding.swipeCategoryDetail.isEnabled = false
        binding.swipeAll.isEnabled = false
    }

    private fun hideAllViews() {
        binding.placeholderView.root.visibility = View.GONE
        binding.tabsRecycler.visibility = View.GONE
        binding.tabDetailsRecycler.visibility = View.GONE
    }

    private fun setupListener() {
        binding.swipeAll.setOnRefreshListener {
            binding.swipeAll.isRefreshing = false
            binding.swipeAll.isEnabled = false
            binding.progressIndicator.visibility = View.VISIBLE
            hideAllViews()

            viewModel.getAllCategory(true)
        }

        binding.swipeCategoryDetail.setOnRefreshListener {
            binding.swipeCategoryDetail.isRefreshing = false
            binding.swipeCategoryDetail.isEnabled = false
            binding.progressIndicator.visibility = View.VISIBLE
            binding.tabDetailsRecycler.visibility = View.GONE
            binding.placeholderView.root.visibility = View.GONE

            viewModel.refreshCategoryDetails()
        }
    }

    private fun initObservers() {
        viewModel.categoryLiveData.observe(viewLifecycleOwner) {
            updatePlaceholderLayoutParams(true)
            if (it.isEmpty()) {
                binding.progressIndicator.visibility = View.GONE
                binding.swipeAll.isEnabled = true
                binding.swipeCategoryDetail.isEnabled = false
                binding.tabsRecycler.visibility = View.GONE
                binding.tabDetailsRecycler.visibility = View.GONE
                binding.placeholderView.root.visibility = View.VISIBLE
            } else {
                binding.swipeAll.isEnabled = false

                categoryTabAdapter.setCategoryTabsInfo(it)
                binding.tabsRecycler.visibility = View.VISIBLE
                binding.tabDetailsRecycler.visibility = View.GONE
                binding.placeholderView.root.visibility = View.GONE
            }
        }

        viewModel.categoryItemsLiveData.observe(viewLifecycleOwner) {
            binding.progressIndicator.visibility = View.INVISIBLE
            binding.tabsRecycler.visibility = View.VISIBLE
            binding.swipeCategoryDetail.isEnabled = true
            updatePlaceholderLayoutParams(false)
            if (it != null) {
                tabItemsAdapter.setTabDetails(it)
                binding.tabDetailsRecycler.visibility = View.VISIBLE

                binding.placeholderView.root.visibility = View.GONE
            } else {

                binding.tabDetailsRecycler.visibility = View.GONE
                binding.placeholderView.root.visibility = View.VISIBLE
            }
        }

        viewModel.selectedCategoryByRowIndexLiveData.observe(viewLifecycleOwner) {
            categoryTabAdapter.setSelectedCategoryTab(it)
        }
    }

    private fun updatePlaceholderLayoutParams(isFull: Boolean) {
        val layoutParams: ConstraintLayout.LayoutParams =
            binding.placeholderView.root.layoutParams as ConstraintLayout.LayoutParams
        if (isFull) {
            layoutParams.topToBottom = binding.headView.id
            binding.placeholderView.root.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.white
                )
            )
        } else {
            layoutParams.topToBottom = binding.tabsRecyclerLayout.id
            binding.placeholderView.root.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.very_light_pink
                )
            )
        }
    }

    override fun showDataForClickedItem(tab: Category, rowIndex: Int) {
        binding.tabDetailsRecycler.visibility = View.GONE
        binding.placeholderView.root.visibility = View.GONE
        binding.progressIndicator.visibility = View.VISIBLE
//        tabItemsAdapter.setTabDetails(emptyList())
        viewModel.getCategoryDetails(tab.id, rowIndex)
    }

    override fun getCategoryItemDetails(categoryId: Int, itemId: Int, view: View) {
        view.findNavController()
            .navigate(
                MarketplaceFragmentDirections.actionMarketplaceFragmentToMarketplaceItemDetailsFragment(
                    categoryId = categoryId,
                    itemId = itemId
                )
            )
    }
}