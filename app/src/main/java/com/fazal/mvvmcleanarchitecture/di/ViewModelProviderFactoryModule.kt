package com.fazal.mvvmcleanarchitecture.di

import androidx.lifecycle.ViewModelProvider
import com.fazal.mvvmcleanarchitecture.presentation.viewModel.ViewModelProviderFactory
import dagger.Binds
import dagger.Module

/**
 * ViewModelFactoryModule responsible for providing [ViewModelProviderFactory]
 *
 * Annotated with Module to tell dagger it is a module to provide [ViewModelProviderFactory]
 *
 * Annotated with bind annotation to efficiently provide dependencies similar to provides annotation
 */
@Module
abstract class ViewModelProviderFactoryModule {

    @Binds
    abstract fun bindViewModelFactory(viewModelProviderFactory: ViewModelProviderFactory) :
            ViewModelProvider.Factory
}