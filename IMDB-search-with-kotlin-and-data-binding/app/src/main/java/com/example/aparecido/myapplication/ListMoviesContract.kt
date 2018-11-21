package com.example.aparecido.myapplication

import com.example.aparecido.myapplication.model.MovieSearchDTO

interface ListMoviesContract {
    interface View {
        fun showContentError()
        fun loadMoviesList(movies: List<MovieSearchDTO>?)
    }

    interface Presenter : BasePresenter<View> {
        fun queryChanged(query: String)
        fun movieClick(movie: MovieSearchDTO)
    }
}