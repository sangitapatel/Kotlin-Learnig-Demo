package com.exmple.MVVM.Coroutine.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.exmple.MVVM.Coroutine.Model.User
import com.exmple.databinding.RowUserBinding

class UserAdapter(val context: Context, private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: RowUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = RowUserBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
        holder.binding.txtName.text = user.name
        holder.binding.txtEmail.text = user.email
        holder.binding.llRow.setOnClickListener {
            Toast.makeText(
                context, "${user.name}\n${user.email}", Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount() = users.size
}