package com.example.aparecido.mymovieapp.domain.repository

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.aparecido.mymovieapp.MyAppDataBase
import com.example.aparecido.mymovieapp.data.api.RetrofitInitializer
import com.example.aparecido.mymovieapp.data.entries.MovieSearch
import com.example.aparecido.mymovieapp.data.entries.MovieSearchResult
import com.example.aparecido.mymovieapp.presentation.MyApplication
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MoviesRepository {

    fun getPopularMoviesList(): LiveData<List<MovieSearch>> {

        val db = MyAppDataBase.getDatabase(MyApplication.context)

        val movieDAO = db.movieDAO()

        val data: MutableLiveData<List<MovieSearch>> = MutableLiveData()

        val moviesCache = movieDAO.all

        if (moviesCache.value == null) {
            RetrofitInitializer.getInstance().movieService()
                .getListOfPopularMovies()
                .enqueue(object : Callback<MovieSearchResult> {

                    override fun onResponse(call: Call<MovieSearchResult>, response: Response<MovieSearchResult>) {
                        val moviesResponse: MovieSearchResult = response.body()!!
                        data.value = moviesResponse.results

                        movieDAO.insertAll(moviesResponse.results)

                        Log.d("TESTE", "aquiiii deu sucesso")
                    }

                    override fun onFailure(call: Call<MovieSearchResult>, t: Throwable) {
                        Log.d("TESTE", "falhouu =(")
                    }

                })

        } else {
            data.value = moviesCache.value
        }

        return data
    }
}