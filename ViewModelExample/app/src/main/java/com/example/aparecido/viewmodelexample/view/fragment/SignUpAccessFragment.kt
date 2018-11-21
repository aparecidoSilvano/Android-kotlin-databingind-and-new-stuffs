package com.example.aparecido.viewmodelexample.view.fragment

import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aparecido.viewmodelexample.R
import com.example.aparecido.viewmodelexample.logic.SignUpViewModel
import kotlinx.android.synthetic.main.activity_login.*

class SignUpAccessFragment: Fragment() {

    var signUpViewModel: SignUpViewModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_sign_up_access, container, false)
    }

    override fun onStart() {
        super.onStart()

        if (activity != null) {
            signUpViewModel = ViewModelProviders.of(activity!!).get(SignUpViewModel::class.java)
        }

        et_email.setText(signUpViewModel?.user?.email)
        et_password.setText(signUpViewModel?.user?.password)
    }

    override fun onPause() {
        super.onPause()

        signUpViewModel?.updateAccessData(et_email.text.toString(), et_password.text.toString())
    }
}