package com.example.aparecido.databindingestudo

open class User(
    val firstName: String,
    val lastName: String,
    val imageUrl: String = "https://www.thiengo.com.br/img/system/logo/logo-thiengo-calopsita-70x70.png",
    val age: Int = 20,
    val isAdult: Boolean = true
) {

    fun fullName(): String = String.format("%s %s", firstName, lastName)
}