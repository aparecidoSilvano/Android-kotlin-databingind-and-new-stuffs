package com.example.aparecido.myapplication.services

import com.example.aparecido.myapplication.model.Movie
import com.example.aparecido.myapplication.model.MovieSearch
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieService {
    @GET(".")
    fun getMovie(@Query("apikey") key: String, @Query("i") title: String): Call<Movie>

    @GET(".")
    fun searchMovie(@Query("apikey") key: String, @Query("s") searchQuery: String): Call<MovieSearch>
}