package com.example.mystable.presentation.marketplace_activity

import android.os.Bundle
import com.example.mystable.R
import dagger.android.support.DaggerAppCompatActivity

class MarketplaceActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_marketplace)
    }
}