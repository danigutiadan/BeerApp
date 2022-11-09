package com.danigutiadan.mo2o_test.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.danigutiadan.mo2o_test.features.beer.search.ui.SearchViewModel

import dagger.Binds
import dagger.Module
import dagger.hilt.migration.DisableInstallInCheck
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
@DisableInstallInCheck
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SearchViewModel::class)
    abstract fun bindSearchViewModel(viewModel: SearchViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
