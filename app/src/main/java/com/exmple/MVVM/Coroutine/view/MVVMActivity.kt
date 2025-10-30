package com.exmple.MVVM.Coroutine.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.MVVM.Coroutine.viewmodel.UserViewModel
import com.exmple.R
import com.exmple.databinding.ActivityMvvmCoroutineBinding

class MVVMActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmCoroutineBinding
    private val viewModel: UserViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_mvvm_coroutine)
        binding.lifecycleOwner = this

        viewModel.fetchUsers()

        viewModel.users.observe(this, Observer {
            binding.recyclerView.layoutManager = LinearLayoutManager(this)
            binding.recyclerView.adapter = UserAdapter(this,it)
        })

        viewModel.error.observe(this, Observer {
            // Show error toast or log
        })
    }
}