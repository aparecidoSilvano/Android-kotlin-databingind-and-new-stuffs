package com.example.aparecido.myapplication.config

import com.example.aparecido.myapplication.services.MovieService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer private constructor() {

    companion object {
        private var INSTANCE: RetrofitInitializer? = null
        fun getInstance(): RetrofitInitializer {
            return INSTANCE ?: synchronized(this) {
                RetrofitInitializer().also {
                    INSTANCE = it
                }
            }
        }
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://www.omdbapi.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun movieService(): MovieService = retrofit.create(MovieService::class.java)
}