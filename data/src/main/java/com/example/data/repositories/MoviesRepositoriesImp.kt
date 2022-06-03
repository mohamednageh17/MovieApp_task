package com.example.data.repositories

import com.example.data.mapper.mapToDomain
import com.example.data.remote.MovieApi
import com.example.domain.model.MovieModel
import com.example.domain.repositories.IMovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MoviesRepositoriesImp @Inject constructor(private val movieApi: MovieApi):IMovieRepository {
    override fun fetchMovies(): Single<List<MovieModel>> {
        return movieApi.getPopularMovies().map{
            it.mapToDomain()
        }
    }
}