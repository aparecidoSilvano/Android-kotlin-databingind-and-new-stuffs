package com.example.aparecido.databindingestudo

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.aparecido.databindingestudo.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        val user = User("José", "Albuquerque")

        binding.user = user
        binding.bindListener = BindListener()

        val usersList = listOf(
            User("aparecido", "albuquerque"),
            User("João", "Soares"),
            User("Thalita", "Dantas"),
            User("Emanuel", "Sales")
        )

        val userAdapter = UsersAdapter(this, usersList)
        val viewManager = LinearLayoutManager(this)

        usersListView.apply {
            layoutManager = viewManager
            adapter = userAdapter
        }
    }
}
