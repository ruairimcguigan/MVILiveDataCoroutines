package com.demo.mvilivedatacoroutines.ui.main.repo

import com.demo.mvilivedatacoroutines.ui.main.movie.Movie
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MoviesService {

    @GET("movie/{movieId}")
    fun getMovieDetailsAsync(@Path("movieId") movieId: Int): Deferred<Response<Movie>>

    @GET("movie/popular")
    fun getPopularMoviesAsync(): Deferred<Response<MoviesResponse>>
}
