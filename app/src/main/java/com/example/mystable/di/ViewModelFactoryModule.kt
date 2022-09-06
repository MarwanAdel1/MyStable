package com.example.mystable.di

import androidx.lifecycle.ViewModelProvider
import com.example.mystable.presentation.DaggerViewModelFactory
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class ViewModelFactoryModule {
    @Singleton
    @Binds
    abstract fun viewModelFactory(factory: DaggerViewModelFactory): ViewModelProvider.Factory
}