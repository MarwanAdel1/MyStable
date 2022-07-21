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
import com.example.mystable.model.Repo
import com.example.mystable.network.BackendServer
import com.example.mystable.pojo.TabInfo
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModel
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModelFactory


class MarketplaceFragment : Fragment(), FragmentCommunicator {
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
        binding = DataBindingUtil.inflate<FragmentMarketplaceBinding>(
            inflater,
            R.layout.fragment_marketplace,
            container,
            false
        )

        tabsAdapter = TabsAdapter(emptyList(), this)
        binding.tabsRecycler.adapter = tabsAdapter
        tabItemsAdapter = TabDetailsAdapter(requireContext(), emptyList())
        binding.tabDetailsRecycler.adapter = tabItemsAdapter

        viewModelFactory = MarketPlaceViewModelFactory(
            Repo.getInstance(BackendServer.getInstance())
        )

        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketPlaceViewModel::
            class.java]

        binding.progressIndicator.visibility = View.VISIBLE
        viewModel.getTabsInfo(true) // true for getting data - false for getting no data

        viewModel.tabsInfoLiveData.observe(viewLifecycleOwner) {
            binding.progressIndicator.visibility = View.INVISIBLE
            if (it != null) {
                if (it.isEmpty()) {
                    binding.mainConstraint.visibility = View.INVISIBLE
                    binding.placeholderTab.visibility = View.VISIBLE
                } else {
                    tabsAdapter.setTabsInfo(it)
                    binding.mainConstraint.visibility = View.VISIBLE
                    binding.placeholderTab.visibility = View.INVISIBLE
                }
            }
        }

        viewModel.tabDetailsLiveData.observe(viewLifecycleOwner) {
            binding.progressIndicator.visibility = View.INVISIBLE
            if (it != null) {
                binding.tabDetailsRecycler.visibility = View.VISIBLE
                tabItemsAdapter.setTabDetails(it.tabItems)
                binding.placeholderTabDetails.visibility = View.INVISIBLE
            } else {
                binding.tabDetailsRecycler.visibility = View.INVISIBLE
                binding.placeholderTabDetails.visibility = View.VISIBLE
            }
        }

        return binding.root
    }

    override fun showDataForClickedItem(tab: TabInfo) {
        binding.tabDetailsRecycler.visibility = View.INVISIBLE
        binding.placeholderTabDetails.visibility = View.INVISIBLE
        binding.progressIndicator.visibility = View.VISIBLE
//        tabItemsAdapter.setTabDetails(emptyList())
        viewModel.getTabDetails(tab.id)
    }
}