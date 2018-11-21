package com.example.aparecido.mymovieapp.data.entries

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class MovieSearch {
    @SerializedName("vote_count")
    @Expose
    val voteCount: Int = 0
    @SerializedName("id")
    @Expose
    val id: Int = 0
    @SerializedName("video")
    @Expose
    val video: Boolean = false
    @SerializedName("vote_average")
    @Expose
    val voteAverage: Double = 0.toDouble()
    @SerializedName("title")
    @Expose
    val title: String? = null
    @SerializedName("popularity")
    @Expose
    val popularity: Double = 0.toDouble()
    @SerializedName("poster_path")
    @Expose
    val posterPath: String? = null
    @SerializedName("original_language")
    @Expose
    val originalLanguage: String? = null
    @SerializedName("original_title")
    @Expose
    val originalTitle: String? = null
    @SerializedName("genre_ids")
    @Expose
    val genreIds: List<Int>? = null
    @SerializedName("backdrop_path")
    @Expose
    val backdropPath: String? = null
    @SerializedName("adult")
    @Expose
    val adult: Boolean = false
    @SerializedName("overview")
    @Expose
    val overview: String? = null
    @SerializedName("release_date")
    @Expose
    val releaseDate: String? = null
}