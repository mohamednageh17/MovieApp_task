package com.example.data.mapper

import com.example.data.model.MovieResponse
import com.example.domain.model.MovieModel

fun MovieResponse.mapToDomain()=this.results?.map {
    MovieModel(
        id=it.id,
        name = it.name,
        backdropPath = it.backdropPath,
        firstAirDate = it.firstAirDate,
        originalLanguage = it.originalLanguage,
        originalName = it.originalName,
        overview = it.overview,
        popularity = it.popularity,
        posterPath = it.posterPath,
        voteAverage = it.voteAverage,
        voteCount = it.voteCount
    )
}