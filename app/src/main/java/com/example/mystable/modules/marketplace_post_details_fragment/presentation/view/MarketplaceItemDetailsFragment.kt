package com.example.mystable.modules.marketplace_post_details_fragment.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.mystable.R
import com.example.mystable.databinding.FragmentMarketplaceItemDetailsBinding
import com.example.mystable.modules.DaggerViewModelFactory
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.view.adapter.ViewsRecyclerAdapter
import com.example.mystable.modules.marketplace_post_details_fragment.presentation.viewmodel.MarketplaceItemDetailsViewModel
import com.example.mystable.modules.posts_adapter.presentation.view.PostsClickCallback
import dagger.android.support.DaggerFragment
import javax.inject.Inject


class MarketplaceItemDetailsFragment : DaggerFragment(), PostsClickCallback {
    private lateinit var binding: FragmentMarketplaceItemDetailsBinding

    @Inject
    lateinit var viewModelFactory: DaggerViewModelFactory

    private lateinit var viewModel: MarketplaceItemDetailsViewModel

    private var itemId: Int = -1
    private var categoryId: Int = -1

    private lateinit var viewsAdapter: ViewsRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMarketplaceItemDetailsBinding.inflate(inflater, container, false)

        itemId = MarketplaceItemDetailsFragmentArgs.fromBundle(requireArguments()).itemId
        categoryId = MarketplaceItemDetailsFragmentArgs.fromBundle(requireArguments()).categoryId

        return binding.root
    }

    private fun init() {
        viewsAdapter =
            ViewsRecyclerAdapter(requireContext(), requireActivity(), this)
        binding.viewsRecyclerview.adapter = viewsAdapter


        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketplaceItemDetailsViewModel::class.java]

        viewModel.getItemDetails(categoryId, itemId)
        viewModel.getSimilarItems(categoryId)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
        setupListeners()
        setupObservers()
    }

    private fun setupListeners() {
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
                .popBackStack(R.id.marketplacePostsFragment, false)
        }

        binding.viewsRecyclerview.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(-1)) {
                    binding.viewMoreBt.visibility = View.VISIBLE
                } else {
                    binding.viewMoreBt.visibility = View.GONE
                }
            }
        })
    }

    private fun setupObservers() {
        viewModel.itemDataLiveData.observe(viewLifecycleOwner) {
            it?.let { data ->
                viewsAdapter.setViews(data.postDetails)
                binding.progressIndicator.visibility = View.GONE
            }
        }

        viewModel.similarItemsLiveData.observe(viewLifecycleOwner) {
            it?.let { items ->
                viewsAdapter.setSimilarItems(items)
                binding.viewMoreBt.visibility = View.VISIBLE
            }
        }
    }

    override fun getPostDetails(categoryId: Int, itemId: Int, view: View) {
        // used to navigate to item selected
    }
}