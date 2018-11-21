package com.example.aparecido.mymovieapp.data.entries

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieSearchResult {
    @SerializedName("page")
    @Expose
    private val page: Int = 0
    @SerializedName("total_results")
    @Expose
    private val totalResults: Int = 0
    @SerializedName("total_pages")
    @Expose
    private val totalPages: Int = 0
    @SerializedName("results")
    @Expose
    val results: List<MovieSearch>? = null
}