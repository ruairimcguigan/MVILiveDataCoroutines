package com.demo.mvilivedatacoroutines.ui.main.repo

import com.demo.mvilivedatacoroutines.ui.main.movie.Movie

sealed class MoviesResult : Result {

    data class HasSucceeded(val data: List<Movie>): MoviesResult()
    data class HasFailed(val error: Throwable): MoviesResult()

    object IsLoading: MoviesResult()
}