package com.example.mystable.marketplace_category_fragment.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.findNavController
import com.example.mystable.R
import com.example.mystable.databinding.FragmentMarketplaceBinding
import com.example.mystable.DaggerViewModelFactory
import com.example.mystable.marketplace_category_fragment.data.model.Category
import com.example.mystable.marketplace_category_fragment.data.model.CategoryDetails
import com.example.mystable.marketplace_category_fragment.presentation.view.adapter.CategoryTabAdapter
import com.example.mystable.marketplace_category_fragment.presentation.view.adapter.CategoryTabItemsAdapter
import com.example.mystable.marketplace_category_fragment.presentation.viewmodel.MarketPlaceViewModel
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class MarketplaceFragment : DaggerFragment(), MarketplaceCategoriesCallBack,
    MarketplaceCategoryItemsCallback {
    private lateinit var binding: FragmentMarketplaceBinding

    private lateinit var viewModel: MarketPlaceViewModel

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    private lateinit var categoryTabAdapter: CategoryTabAdapter
    private lateinit var tabItemsAdapter: CategoryTabItemsAdapter

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
        categoryTabAdapter = CategoryTabAdapter(requireContext(), emptyList(), this)
        tabItemsAdapter =
            CategoryTabItemsAdapter(requireContext(), CategoryDetails(-1, emptyList()), this)
        binding.tabsRecycler.adapter = categoryTabAdapter
        binding.tabDetailsRecycler.adapter = tabItemsAdapter

        initViews()

        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketPlaceViewModel::
            class.java]
    }

    private fun initViews() {
        binding.countryBt.text = "Egypt"  // temp

        binding.progressIndicator.visibility = View.VISIBLE

        binding.swipeCategoryDetail.isEnabled = false
        binding.swipeAll.isEnabled = false
    }

    private fun setupListener() {
        binding.swipeAll.setOnRefreshListener {
            setupViewsForRefreshAll()
            viewModel.getAllCategory(true)
        }

        binding.swipeCategoryDetail.setOnRefreshListener {
            setupViewsForRefreshCategory()
            viewModel.refreshCategoryDetails()
        }
    }

    private fun setupViewsForRefreshAll() {
        binding.swipeAll.isRefreshing = false
        binding.swipeAll.isEnabled = false
        binding.progressIndicator.visibility = View.VISIBLE
        binding.placeholderView.root.visibility = View.GONE
        binding.tabsRecycler.visibility = View.GONE
        binding.tabDetailsRecycler.visibility = View.GONE
    }

    private fun setupViewsForRefreshCategory() {
        binding.swipeCategoryDetail.isRefreshing = false
        binding.swipeCategoryDetail.isEnabled = false
        binding.progressIndicator.visibility = View.VISIBLE
        binding.tabDetailsRecycler.visibility = View.GONE
        binding.placeholderView.root.visibility = View.GONE
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

    override fun setCategorySelected(rowIndex: Int) {
        viewModel.setSelectedCategoryIndex(rowIndex)
    }

    override fun showDataForClickedItem(tab: Category) {
        binding.tabDetailsRecycler.visibility = View.GONE
        binding.placeholderView.root.visibility = View.GONE
        binding.progressIndicator.visibility = View.VISIBLE

        viewModel.getCategoryDetails(tab.id)
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