package com.exmple.MVVM.WithoutCoroutine.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.exmple.MVVM.WithoutCoroutine.model.User
import com.exmple.databinding.ItemWithoutUserBinding

class UserAdapter(val context: Context,private var users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: ItemWithoutUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemWithoutUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = users[position]
//        holder.binding.user = user
        holder.binding.tvName.text = user.name
        holder.binding.tvEmail.text = user.email
        holder.binding.llRow.setOnClickListener {
            Toast.makeText(
                context, "${user.name}\n${user.email}", Toast.LENGTH_LONG
            ).show()
        }
    }

    fun updateList(newList: List<User>) {
        users = newList
        notifyDataSetChanged()
    }
}