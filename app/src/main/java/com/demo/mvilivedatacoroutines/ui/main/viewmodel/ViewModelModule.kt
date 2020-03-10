package com.demo.mvilivedatacoroutines.ui.main.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.demo.mvilivedatacoroutines.ui.main.base.ViewModelKey
import com.demo.mvilivedatacoroutines.ui.main.movie.MoviesViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    internal abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MoviesViewModel::class)
    abstract fun bindMovieViewModel(viewModel: MoviesViewModel): ViewModel
}