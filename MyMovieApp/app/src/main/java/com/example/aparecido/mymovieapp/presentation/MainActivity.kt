package com.example.aparecido.mymovieapp.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.aparecido.mymovieapp.R
import com.example.aparecido.mymovieapp.domain.MovieListViewModel
import com.example.aparecido.mymovieapp.presentation.adapter.MoviesAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var moviesViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setProgressVisibility(savedInstanceState == null)

        moviesViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        moviesViewModel.getPopularMoviesList().observe(this, Observer { popularMoviesList ->

            val movieAdapter = MoviesAdapter(this, popularMoviesList!!)
            val viewManager = LinearLayoutManager(this)

            moviesList.apply {
                layoutManager = viewManager
                adapter = movieAdapter
            }

            setProgressVisibility(false)
        })
    }

    private fun setProgressVisibility(visible: Boolean) {
        var visibility = View.INVISIBLE

        if (visible) {
            visibility = View.VISIBLE
        }

        progressBar.visibility = visibility
    }
}
