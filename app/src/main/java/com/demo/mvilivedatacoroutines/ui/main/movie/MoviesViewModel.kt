package com.demo.mvilivedatacoroutines.ui.main.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.demo.mvilivedatacoroutines.ui.main.dispatcher.MoviesDispatcher
import com.demo.mvilivedatacoroutines.ui.main.base.BaseViewModel
import com.demo.mvilivedatacoroutines.ui.main.repo.MoviesResult
import javax.inject.Inject

class MoviesViewModel @Inject constructor(dispatcher: MoviesDispatcher): BaseViewModel() {

    private val viewState = MoviesViewState()

    val moviesViewState: LiveData<MoviesViewState> =
        Transformations.map(dispatcher.dispatchAction(MoviesAction.FetchMoviesAction)) {
            when(it){
                is MoviesResult.IsLoading -> viewState.copy(isLoading = true)
                is MoviesResult.HasSucceeded -> viewState.copy(
                    isLoading = false,
                    movies = it.data,
                    error = null
                )
                is MoviesResult.HasFailed -> viewState.copy(
                    isLoading = false,
                    error = it.error
                )
            }
        }

}
