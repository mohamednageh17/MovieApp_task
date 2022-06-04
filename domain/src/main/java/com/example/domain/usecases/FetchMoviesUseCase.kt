package com.example.domain.usecases

import com.example.domain.repositories.MovieRepository
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(private val MovieRepository: MovieRepository) {
    operator fun invoke()=MovieRepository.fetchMovies()
}