package com.example.domain.usecases

import com.example.domain.repositories.IMovieRepository
import javax.inject.Inject

class FetchMoviesUseCase @Inject constructor(private val IMovieRepository: IMovieRepository) {
    operator fun invoke()=IMovieRepository.fetchMovies()
}