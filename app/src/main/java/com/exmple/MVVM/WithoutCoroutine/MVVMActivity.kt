package com.exmple.MVVM.WithoutCoroutine

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.MVVM.Coroutine.view.UserAdapter
import com.exmple.MVVM.Coroutine.viewmodel.UserViewModel
import com.exmple.R
import com.exmple.databinding.ActivityMvvmCoroutineBinding

class MVVMActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmCoroutineBinding
    private val viewModel: com.exmple.MVVM.WithoutCoroutine.viewmodel.UserViewModel by viewModels()
    private lateinit var adapter: com.exmple.MVVM.WithoutCoroutine.View.UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_coroutine)
        binding.lifecycleOwner = this

        adapter = com.exmple.MVVM.WithoutCoroutine.View.UserAdapter(this,emptyList())
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        binding.lifecycleOwner = this
        viewModel.userList.observe(this) { users ->
            adapter.updateList(users)
        }

        viewModel.loadUsers()
    }
}