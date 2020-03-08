package com.demo.mvilivedatacoroutines.ui.main.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.SupervisorJob

abstract class BaseViewModel : ViewModel() {

    private val job = SupervisorJob()

    protected val uiScope = CoroutineScope(
        Main + job
    )

    override fun onCleared() {
        super.onCleared()
        job.cancel()
    }
}