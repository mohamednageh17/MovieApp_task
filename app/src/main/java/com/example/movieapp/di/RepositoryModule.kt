package com.example.movieapp.di

import com.example.data.remote.MovieApi
import com.example.data.repositories.MoviesRepositoriesImpl
import com.example.domain.repositories.MovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule{
    @Provides
    fun getRepositoryModule(movieApi: MovieApi): MovieRepository {
        return MoviesRepositoriesImpl(movieApi)
    }

}
