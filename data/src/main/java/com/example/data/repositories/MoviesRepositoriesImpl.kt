package com.example.data.repositories

import com.example.data.mapper.mapToDomain
import com.example.data.remote.MovieApi
import com.example.domain.model.MovieModel
import com.example.domain.repositories.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoriesImpl @Inject constructor(private val movieApi: MovieApi):MovieRepository {
    override fun fetchMovies(): Single<List<MovieModel>> {
        return movieApi.getPopularMovies().map{
            it.mapToDomain()
        }
    }
}