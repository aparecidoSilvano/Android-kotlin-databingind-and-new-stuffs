package com.example.aparecido.myapplication.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieSearchDTO {

    @SerializedName("Title")
    var title: String? = null
    @SerializedName("Year")
    var year: String? = null
    @SerializedName("imdbID")
    @Expose
    var imdbID: String? = null
    @SerializedName("Type")
    @Expose
    var type: String? = null
    @SerializedName("Poster")
    @Expose
    var poster: String? = null

}