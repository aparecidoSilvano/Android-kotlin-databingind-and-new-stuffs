package com.example.aparecido.mymovieapp.data.api

import okhttp3.OkHttpClient
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

    private val httpClient = OkHttpClient.Builder().addInterceptor { chain ->
        val original = chain.request()
        val originalHttpUrl = original.url()

        val url = originalHttpUrl.newBuilder()
            .addQueryParameter("api_key", "d48f22a0cfb2b3478f12b6d5173e3148")
            .build()

        // Request customization: add request headers
        val requestBuilder = original.newBuilder()
            .url(url)

        val request = requestBuilder.build()
        chain.proceed(request)
    }

    private val retrofit = Retrofit.Builder()
        .baseUrl("https://api.themoviedb.org")
        .addConverterFactory(GsonConverterFactory.create())
        .client(httpClient.build())
        .build()

    fun movieService(): MovieService = retrofit.create(MovieService::class.java)
}