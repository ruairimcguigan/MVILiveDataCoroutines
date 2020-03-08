package com.demo.mvilivedatacoroutines.ui.main.base

import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseView : DaggerFragment() {

    @Inject lateinit var baseViewModel: BaseViewModelFactory
}