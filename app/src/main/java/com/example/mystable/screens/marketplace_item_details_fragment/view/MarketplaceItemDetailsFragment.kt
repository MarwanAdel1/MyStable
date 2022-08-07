package com.example.mystable.screens.marketplace_item_details_fragment.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.mystable.R
import com.example.mystable.databinding.FragmentMarketplaceItemDetailsBinding
import com.example.mystable.model.MarketplaceRepo
import com.example.mystable.network.MarketplaceDataSource
import com.example.mystable.pojo.CategoryItemData
import com.example.mystable.screens.marketplace_item_details_fragment.viewmodel.MarketplaceItemDetailsViewModel
import com.example.mystable.screens.marketplace_item_details_fragment.viewmodel.MarketplaceItemDetailsViewModelFactory

class MarketplaceItemDetailsFragment : Fragment(), MarketplaceItemDetailsSimilarItemCallback {
    private lateinit var binding: FragmentMarketplaceItemDetailsBinding

    private lateinit var viewModelFactory: MarketplaceItemDetailsViewModelFactory
    private lateinit var viewModel: MarketplaceItemDetailsViewModel

    private var itemId: Int = -1
    private var categoryId: Int = -1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMarketplaceItemDetailsBinding.inflate(inflater, container, false)

        itemId = MarketplaceItemDetailsFragmentArgs.fromBundle(requireArguments()).itemId
        categoryId = MarketplaceItemDetailsFragmentArgs.fromBundle(requireArguments()).categoryId

        viewModelFactory =
            MarketplaceItemDetailsViewModelFactory(MarketplaceRepo(MarketplaceDataSource()))
        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketplaceItemDetailsViewModel::class.java]

        viewModel.getItemDetails(categoryId, itemId)
        viewModel.getSimilarItems(categoryId)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewsAdapter = ViewsRecyclerAdapter(mutableListOf(), requireContext(), this)
        binding.viewsRecyclerview.adapter = viewsAdapter

        viewModel.itemDataLiveData.observe(viewLifecycleOwner) {
            it?.let { data -> viewsAdapter.setViews(data.itemData) }
        }

        viewModel.similarItemsLiveData.observe(viewLifecycleOwner) {
            it?.let { items ->
                viewsAdapter.setSimilarItems(items)
                binding.viewMoreBt.visibility = View.VISIBLE
            }
        }

        binding.viewMoreBt.setOnClickListener {
            binding.viewsRecyclerview.layoutManager?.smoothScrollToPosition(
                binding.viewsRecyclerview,
                null,
                viewsAdapter.itemCount
            )
            binding.viewMoreBt.visibility = View.GONE
        }

        binding.backBt.setOnClickListener {
            it.findNavController()
                .popBackStack(R.id.marketplaceFragment, false)
        }
    }

    override fun getSimilarItemDetails(categoryId: Int, itemDetails: CategoryItemData, view: View) {

    }
}