package com.example.aparecido.databindingestudo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.aparecido.databindingestudo.databinding.UserBinding

class UsersAdapter(
    private val context: Context,
    private val users: List<User>
) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(context)

        val userBinding = UserBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(userBinding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(users[position])
    }

    override fun getItemCount(): Int {
        return users.size
    }

    inner class ViewHolder(private val binding: UserBinding) : RecyclerView.ViewHolder(binding.root) {
        fun setData(user: User) {
            binding.user = user
            /*
             Note a importância da invocação do método executePendingBindings() para que a atualização de item ocorra imediatamente.
             Este método deve ser invocado de maneira direta ou indireta pelo onBindViewHolder().
             */
            binding.executePendingBindings()
        }
    }
}