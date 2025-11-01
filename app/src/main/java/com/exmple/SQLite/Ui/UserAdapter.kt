package com.exmple.SQLite.Ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.exmple.SQLite.Data.User
import com.exmple.databinding.ItemSqlBinding

class UserAdapter(
    private var userList: List<User>,
    private val onDelete: (User) -> Unit
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    inner class UserViewHolder(val binding: ItemSqlBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemSqlBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun getItemCount() = userList.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.tvName.text = user.name
        holder.binding.tvEmail.text = user.email
        holder.binding.btnDelete.setOnClickListener {
            onDelete(user)
        }
    }

    fun updateData(newList: List<User>) {
        userList = newList
        notifyDataSetChanged()
    }
}