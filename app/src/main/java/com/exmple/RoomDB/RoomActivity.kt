package com.exmple.RoomDB

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.R
import com.exmple.RoomDB.Data.AppDatabase
import com.exmple.RoomDB.Data.UserRepository
import com.exmple.RoomDB.UI.UserAdapter
import com.exmple.RoomDB.UI.UserViewModel
import com.exmple.databinding.ActivityRoomBinding
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
class RoomActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRoomBinding
    private lateinit var adapter: UserAdapter
    private val viewModel by viewModels<UserViewModel> {
        val dao = AppDatabase.getDatabase(this).userDao()
        val repo = UserRepository(dao)
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return UserViewModel(repo) as T
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRoomBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserAdapter(emptyList())
        binding.rvUsers.layoutManager = LinearLayoutManager(this)
        binding.rvUsers.adapter = adapter

        binding.btnAdd.setOnClickListener {
            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            if (name.isNotEmpty() && email.isNotEmpty()) {
                viewModel.addUser(name, email)
                binding.etName.text.clear()
                binding.etEmail.text.clear()
            }
        }

        binding.btnClear.setOnClickListener {
            viewModel.deleteAll()
        }

        lifecycleScope.launch {
            viewModel.users.collectLatest {
                adapter.updateData(it)
            }
        }
    }
}