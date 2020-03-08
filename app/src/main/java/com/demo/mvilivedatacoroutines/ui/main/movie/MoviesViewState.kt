package com.demo.mvilivedatacoroutines.ui.main.movie

import com.demo.mvilivedatacoroutines.ui.main.base.BaseViewState
import com.google.gson.annotations.SerializedName

data class MoviesViewState(
    @SerializedName("results")
    val isLoading: Boolean = false,
    val movies: List<Movie> = emptyList(),
    val error: Throwable? = null
) : BaseViewState