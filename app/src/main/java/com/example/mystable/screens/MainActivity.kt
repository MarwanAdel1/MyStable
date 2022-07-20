package com.example.mystable.screens

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.mystable.R
import com.example.mystable.databinding.ActivityMarketplaceBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMarketplaceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_marketplace)


    }
}