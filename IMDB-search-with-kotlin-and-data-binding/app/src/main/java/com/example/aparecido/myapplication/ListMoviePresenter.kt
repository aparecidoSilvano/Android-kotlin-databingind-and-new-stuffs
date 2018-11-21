package com.example.aparecido.myapplication

import android.util.Log
import com.example.aparecido.myapplication.config.RetrofitInitializer
import com.example.aparecido.myapplication.model.Movie
import com.example.aparecido.myapplication.model.MovieSearch
import com.example.aparecido.myapplication.model.MovieSearchDTO
import retrofit2.Call
import retrofit2.Response

class ListMoviePresenter : ListMoviesContract.Presenter {
    private lateinit var mView: ListMoviesContract.View

    companion object {
        const val MY_IMDB_KEY: String = "ffc558fc"
    }

    override fun attach(view: ListMoviesContract.View) {
        mView = view
    }

    override fun queryChanged(query: String) {
        RetrofitInitializer.getInstance().movieService().searchMovie(MY_IMDB_KEY, query)
            .enqueue(object : retrofit2.Callback<MovieSearch> {
                override fun onResponse(call: Call<MovieSearch>, response: Response<MovieSearch>) {

                    if (response.isSuccessful && response.body() != null
                        && response.body()!!.search != null
                    ) {

                        mView.loadMoviesList(response.body()!!.search)

                    } else {
                        mView.showContentError()
                    }
                }

                override fun onFailure(call: Call<MovieSearch>, throwable: Throwable) {
                    mView.showContentError()
                }
            })
    }

    override fun movieClick(movie: MovieSearchDTO) {
        if (movie.imdbID != null) {
            RetrofitInitializer.getInstance().movieService().getMovie(MY_IMDB_KEY, movie.imdbID!!)
                .enqueue(object : retrofit2.Callback<Movie> {
                    override fun onResponse(call: Call<Movie>, response: Response<Movie>) {
                        Log.d("TESTE", "no onResponse" + response.body().toString())
                    }

                    override fun onFailure(call: Call<Movie>, throwable: Throwable) {
                        Log.d("TESTE", "no onFailure, t = ${throwable.message}")
                    }
                })
        }
    }

    override fun detach() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}