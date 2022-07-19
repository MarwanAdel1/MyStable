package com.example.mystable.screens.marketplace_screen.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.mystable.R
import com.example.mystable.model.Repo
import com.example.mystable.network.BackendServer
import com.example.mystable.screens.marketplace_screen.viewmodel.MarketPlaceViewModel
import com.example.mystable.screens.marketplace_screen.viewmodel.MarketPlaceViewModelFactory

class MarketplaceScreen : AppCompatActivity() {
    private lateinit var viewModel: MarketPlaceViewModel
    private lateinit var viewModelFactory: MarketPlaceViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketplace)


        viewModelFactory = MarketPlaceViewModelFactory(
            Repo.getInstance(BackendServer.getInstance())
        )

        viewModel =
            ViewModelProvider(this, viewModelFactory)[MarketPlaceViewModel::
            class.java]

        viewModel.getTabsInfo(true)

        viewModel.tabsInfoLiveData.observe(this) {
            if (it != null) {
                println("Welcome Data\n")
                it.forEach {
                    println(it.name)
                }
            }
        }


    }
}