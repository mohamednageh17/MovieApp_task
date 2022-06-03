package com.example.domain.di

import com.example.domain.repositories.IMovieRepository
import com.example.domain.usecases.FetchMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object UseCaseModule{
    @Provides
    fun provideFetchMoviesUseCase(movieRepository: IMovieRepository):FetchMoviesUseCase{
        return FetchMoviesUseCase(movieRepository)
    }
}
