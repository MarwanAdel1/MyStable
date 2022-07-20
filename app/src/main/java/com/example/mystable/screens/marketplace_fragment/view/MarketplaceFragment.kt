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
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModel
import com.example.mystable.screens.marketplace_fragment.viewmodel.MarketPlaceViewModelFactory


class MarketplaceFragment : Fragment() {
    private lateinit var binding: FragmentMarketplaceBinding

    private lateinit var viewModel: MarketPlaceViewModel
    private lateinit var viewModelFactory: MarketPlaceViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentMarketplaceBinding>(
            inflater,
            R.layout.fragment_marketplace,
            container,
            false
        )

        viewModelFactory = MarketPlaceViewModelFactory(
            Repo.getInstance(BackendServer.getInstance())
        )

        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketPlaceViewModel::
            class.java]

        viewModel.getTabsInfo(true)

        viewModel.tabsInfoLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                println("Welcome Data\n")
                it.forEach {
                    println(it.name)
                }
            }
        }


        return binding.root
    }
}