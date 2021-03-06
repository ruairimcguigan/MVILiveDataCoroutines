package com.demo.mvilivedatacoroutines.ui.main.base

import com.demo.mvilivedatacoroutines.ui.main.viewmodel.ViewModelFactory
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseView : DaggerFragment() {

    @Inject lateinit var viewModel: ViewModelFactory
}