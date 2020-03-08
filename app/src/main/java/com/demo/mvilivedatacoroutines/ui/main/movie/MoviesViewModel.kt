package com.demo.mvilivedatacoroutines.ui.main.movie

import com.demo.mvilivedatacoroutines.ui.main.MoviesDispatcher
import com.demo.mvilivedatacoroutines.ui.main.base.BaseViewModel
import javax.inject.Inject

class MoviesViewModel @Inject constructor(dispatcher: MoviesDispatcher): BaseViewModel() {

    private val viewState = MoviesViewState()

}
