package com.example.aparecido.myapplication

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aparecido.myapplication.databinding.ItemMovieBinding
import com.example.aparecido.myapplication.model.MovieSearchDTO

class MoviesAdapter(private val context: Context, private val moviesList: List<MovieSearchDTO>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    lateinit var itemClickListener: ItemMovieClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val movieBinding = ItemMovieBinding.inflate(layoutInflater, parent, false)

        return MovieViewHolder(movieBinding)
    }

    override fun getItemCount(): Int {
        return moviesList.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.setData(moviesList[position])
    }

    inner class MovieViewHolder(private val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun setData(movie: MovieSearchDTO){
            binding.movie = movie

            binding.executePendingBindings()
        }

        override fun onClick(v: View?) {
            itemClickListener.onItemCLick(adapterPosition)
        }

    }
}