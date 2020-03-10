package com.demo.mvilivedatacoroutines.ui.main.repo

class MoviesRepository(private val movieService: MoviesService) {

    suspend fun getMovieDetails() = movieService.getMovieDetailsAsync(550).await()

    suspend fun getPopularMovies() = movieService.getPopularMoviesAsync().await()

}
