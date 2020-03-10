package com.demo.mvilivedatacoroutines.ui.main.base

import com.demo.mvilivedatacoroutines.ui.main.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    protected abstract fun render(state: BaseViewState)
}