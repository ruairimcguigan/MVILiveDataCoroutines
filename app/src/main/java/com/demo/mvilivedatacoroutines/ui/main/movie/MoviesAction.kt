package com.demo.mvilivedatacoroutines.ui.main.movie

import com.demo.mvilivedatacoroutines.ui.main.base.BaseAction

sealed class MoviesAction : BaseAction {

    object FetchMoviesAction: MoviesAction()
}