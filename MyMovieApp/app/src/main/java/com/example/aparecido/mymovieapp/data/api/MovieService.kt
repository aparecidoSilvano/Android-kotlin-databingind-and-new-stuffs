package com.example.aparecido.mymovieapp.data.api

import com.example.aparecido.mymovieapp.data.entries.MovieSearchResult
import retrofit2.Call
import retrofit2.http.GET

interface MovieService {

    @GET("/3/discover/movie")
    fun getListOfPopularMovies(): Call<MovieSearchResult>
}