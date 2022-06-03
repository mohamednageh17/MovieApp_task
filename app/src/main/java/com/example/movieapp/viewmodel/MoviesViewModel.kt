package com.example.movieapp.viewmodel

import com.example.domain.model.MovieModel
import com.example.domain.usecases.FetchMoviesUseCase
import com.example.movieapp.handle_state.StateLiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.addTo
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class MoviesViewModel @Inject constructor(private val fetchMoviesUseCase: FetchMoviesUseCase) : BaseViewModel() {
    private val _moviesLiveData by lazy { StateLiveData<List<MovieModel>>() }
    val moviesLiveDate = _moviesLiveData

    init {
        fetchMovies()
    }

    fun fetchMovies() {
        fetchMoviesUseCase()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _moviesLiveData.postLoading() }
            .subscribe({
                _moviesLiveData.postSuccess(it)
            }, {
                _moviesLiveData.postError(it)
            }).addTo(compositeDisposable)
    }
}
