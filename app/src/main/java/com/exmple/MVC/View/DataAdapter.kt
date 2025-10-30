package com.exmple.MVC.View

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.exmple.MVC.Model.DataModel
import com.exmple.databinding.RowDataBinding

class DataAdapter(val context: Context, private val userList: List<DataModel>) :
    RecyclerView.Adapter<DataAdapter.DataViewHolder>() {

    inner class DataViewHolder(val binding: RowDataBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder {
        val binding = RowDataBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return DataViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        val user = userList[position]
        holder.binding.txtName.text = user.name
        holder.binding.txtEmail.text = user.email
        holder.binding.llRow.setOnClickListener {
            Toast.makeText(
                context, "${user.name}\n${user.email}", Toast.LENGTH_LONG
            ).show()
        }
    }

    override fun getItemCount(): Int = userList.size
}