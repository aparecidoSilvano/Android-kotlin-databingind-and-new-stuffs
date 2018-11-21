package com.example.aparecido.mymovieapp.domain.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.aparecido.mymovieapp.data.entries.MovieSearch
import com.example.aparecido.mymovieapp.data.entries.MovieSearchResult
import com.example.aparecido.mymovieapp.data.api.RetrofitInitializer
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository {

    fun getPopularMoviesList(): LiveData<List<MovieSearch>> {

        val data: MutableLiveData<List<MovieSearch>> = MutableLiveData()

        RetrofitInitializer.getInstance().movieService()
            .getListOfPopularMovies()
            .enqueue(object : Callback<MovieSearchResult> {

                override fun onResponse(call: Call<MovieSearchResult>, response: Response<MovieSearchResult>) {
                    val moviesResponse: MovieSearchResult = response.body()!!
                    data.value = moviesResponse.results

                    Log.d("TESTE", "aquiiii deu sucesso")
                }

                override fun onFailure(call: Call<MovieSearchResult>, t: Throwable) {
                    Log.d("TESTE", "falhouu =(")
                }

            })

        return data
    }
}