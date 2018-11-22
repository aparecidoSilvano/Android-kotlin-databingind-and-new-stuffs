package com.example.aparecido.mymovieapp.domain

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.aparecido.mymovieapp.data.entries.MovieSearch
import com.example.aparecido.mymovieapp.domain.repository.MoviesRepository

class MovieListViewModel : ViewModel() {
    private val moviesRepository: MoviesRepository =
        MoviesRepository()

    val popularMoviesList: LiveData<List<MovieSearch>>

    init {
        popularMoviesList = moviesRepository.getPopularMoviesList()
    }
}