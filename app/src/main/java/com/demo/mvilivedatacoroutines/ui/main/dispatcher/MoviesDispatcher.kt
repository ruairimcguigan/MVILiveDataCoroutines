package com.demo.mvilivedatacoroutines.ui.main.dispatcher

import androidx.lifecycle.liveData
import com.demo.mvilivedatacoroutines.ui.main.base.BaseAction
import com.demo.mvilivedatacoroutines.ui.main.movie.MoviesAction
import com.demo.mvilivedatacoroutines.ui.main.repo.MoviesRepository
import com.demo.mvilivedatacoroutines.ui.main.repo.MoviesResult
import javax.inject.Inject

class MoviesDispatcher @Inject constructor(
    private val repo: MoviesRepository) {

    /**
     * When the emit() function is executed, it returns a MoviesResult
     * LiveData object that is observed by the transformation in our ViewModel.
     * Emit will set the value of the LiveData object in the background on a
     * scoped coroutine. Once the value is emitted, our ViewModel will take
     * over and return a new ViewState based on the result
     */
    fun dispatchAction(action: BaseAction) = liveData {
        when (action) {
            is MoviesAction.FetchMoviesAction -> {
                emit(MoviesResult.IsLoading)
                emit(fetchPopularMovies())
            }
        }
    }

    private suspend fun fetchPopularMovies(): MoviesResult {
        try {
            val response = repo.getPopularMovies()
            if (response.isSuccessful) {
                response.body()?.let { responseBody ->
                    responseBody.results?.run {
                        return MoviesResult.HasSucceeded(this)
                    }
                }
            }
        } catch (t: Throwable) {
            return MoviesResult.HasFailed(t.localizedMessage)
        }

        return MoviesResult.HasFailed("Failure to retrieve movies")
    }
}