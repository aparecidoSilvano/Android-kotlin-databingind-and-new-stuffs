package com.example.aparecido.viewmodelexample.logic

import android.arch.lifecycle.ViewModel
import com.example.aparecido.viewmodelexample.model.User

class SignUpViewModel: ViewModel() {
    val user: User = User()

    fun updatePersonData(
        imagePath: String,
        name: String,
        profession: String) {

        user.imagePath = imagePath
        user.name = name
        user.profession = profession
    }

    fun updateAccessData(email: String, password: String) {
        user.email = email
        user.password = password
    }

    fun updateTermsData(terms: Boolean) {
        user.statusTerms = terms
    }
}