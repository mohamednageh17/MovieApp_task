package com.example.data.di

import com.example.data.remote.MovieApi
import com.example.data.repositories.MoviesRepositoriesImp
import com.example.domain.repositories.IMovieRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule{

    @Provides
    fun getRepositoryModule(movieApi: MovieApi):IMovieRepository{
        return MoviesRepositoriesImp(movieApi)
    }

}