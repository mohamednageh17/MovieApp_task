package com.example.data.remote

import com.example.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET

interface MovieApi {
    @GET("popular?")
    fun getPopularMovies(): Single<MovieResponse>

}