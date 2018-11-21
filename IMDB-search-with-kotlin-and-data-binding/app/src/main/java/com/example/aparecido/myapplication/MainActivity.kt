package com.example.aparecido.myapplication

import android.app.SearchManager
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.View
import com.example.aparecido.myapplication.model.MovieSearchDTO
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), ListMoviesContract.View, SearchView.OnQueryTextListener,
    ItemMovieClickListener {

    private var mPresenter: ListMoviesContract.Presenter = ListMoviePresenter()
    private lateinit var viewAdapter: MoviesAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var searchView: SearchView
    private var lastMovieSearched: String = ""
    private lateinit var sharedPref: SharedPreferences
    private lateinit var foundedMovies: List<MovieSearchDTO>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewManager = LinearLayoutManager(this)
        mPresenter.attach(this)

        sharedPref = getPreferences(Context.MODE_PRIVATE)
        lastMovieSearched = sharedPref.getString(LAST_SEARCH_KEY, "")!!

        if (!lastMovieSearched.isEmpty()) {
            setProgressVisibility(true)
            tvSearchStatus.visibility = View.VISIBLE
            mPresenter.queryChanged(lastMovieSearched)
        } else {
            tvSearchStatus.text = getString(R.string.use_the_search)
            tvSearchStatus.visibility = View.VISIBLE
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)

        if (menu != null) {
            val searchManager: SearchManager = getSystemService(Context.SEARCH_SERVICE) as SearchManager
            val item = menu.findItem(R.id.action_searchable_activity)
            searchView = item.actionView as SearchView

            searchView.setSearchableInfo(searchManager.getSearchableInfo(componentName))
            searchView.queryHint = getString(R.string.search_hint)

            searchView.setOnQueryTextListener(this)
        }

        return true
    }

    override fun loadMoviesList(movies: List<MovieSearchDTO>?) {
        foundedMovies = movies!!

        viewAdapter = MoviesAdapter(this, movies)
        viewAdapter.itemClickListener = this

        plantsRecyclerView.apply {
            layoutManager = viewManager
            adapter = viewAdapter
        }

        setProgressVisibility(false)
        setListVisibility(true)

        saveLastMovieSearched()
    }

    override fun onItemCLick(position: Int) {
        //mPresenter.movieClick(foundedMovies[position])
    }

    private fun saveLastMovieSearched() {
        sharedPref.edit().putString(LAST_SEARCH_KEY, lastMovieSearched).apply()
    }

    override fun showContentError() {
        setProgressVisibility(false)
        tvSearchStatus.text = getString(R.string.movie_not_found)
        tvSearchStatus.visibility = View.VISIBLE
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query != null) {
            setListVisibility(false)
            setProgressVisibility(true)
            tvSearchStatus.visibility = View.GONE
            mPresenter.queryChanged(query)
            searchView.clearFocus()
            lastMovieSearched = query
        }

        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        return true
    }

    private fun setListVisibility(isVisible: Boolean) {
        if (isVisible) {
            plantsRecyclerView.visibility = View.VISIBLE
        } else {
            plantsRecyclerView.visibility = View.INVISIBLE
        }
    }

    private fun setProgressVisibility(isVisible: Boolean) {
        if (isVisible) {
            tvSearchingLabel.visibility = View.VISIBLE
            progressBar.visibility = View.VISIBLE
        } else {
            tvSearchingLabel.visibility = View.INVISIBLE
            progressBar.visibility = View.INVISIBLE
        }
    }

    companion object {
        const val LAST_SEARCH_KEY = "LAST_SEARCH_KEY"
    }
}
