package com.example.aparecido.databindingestudo

import android.view.View
import android.widget.Toast

class Util {
    companion object {
        @JvmStatic
        val CONSTANT = "O valor de uma constante importante pro projeto"

        @JvmStatic
        fun listenerClick(view: View, user: User) {
            Toast.makeText(view.context, "${user.firstName} ${user.lastName}", Toast.LENGTH_SHORT).show()
        }
    }
}