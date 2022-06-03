package com.example.domain.repositories

import com.example.domain.model.MovieModel
import io.reactivex.Single

interface IMovieRepository {
    fun fetchMovies():Single<List<MovieModel>>
}