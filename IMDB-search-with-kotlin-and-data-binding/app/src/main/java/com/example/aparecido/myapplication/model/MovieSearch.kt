package com.example.aparecido.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieSearch {

    @SerializedName("Search")
    @Expose
    var search: List<MovieSearchDTO>? = null
    @SerializedName("totalResults")
    @Expose
    var totalResults: String? = null
    @SerializedName("Response")
    @Expose
    var response: String? = null
}