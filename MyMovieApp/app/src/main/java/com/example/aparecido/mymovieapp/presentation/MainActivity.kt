package com.example.aparecido.mymovieapp.presentation

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.aparecido.mymovieapp.domain.MovieListViewModel
import com.example.aparecido.mymovieapp.R

class MainActivity : AppCompatActivity() {

    private lateinit var moviesViewModel: MovieListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        moviesViewModel = ViewModelProviders.of(this).get(MovieListViewModel::class.java)
    }

    override fun onStart() {
        super.onStart()

        moviesViewModel.getPopularMoviesList().observe(this, Observer { popularMoviesList ->
            // Atualizar a lista, pois chegaram os dados dos filmes
            Toast.makeText(this, "Atualizar a lista, pois chegaram os dados dos filmes", Toast.LENGTH_SHORT).show()
        })
    }
}
