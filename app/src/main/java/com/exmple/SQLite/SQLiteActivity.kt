package com.exmple.SQLite
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.SQLite.Data.DatabaseHelper
import com.exmple.SQLite.Data.User
import com.exmple.SQLite.Ui.UserAdapter
import com.exmple.databinding.ActivitySqliteBinding

class SQLiteActivity : AppCompatActivity() {

        private lateinit var binding: ActivitySqliteBinding
        private lateinit var dbHelper: DatabaseHelper
        private lateinit var adapter: UserAdapter

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivitySqliteBinding.inflate(layoutInflater)
            setContentView(binding.root)

            dbHelper = DatabaseHelper(this)
            adapter = UserAdapter(emptyList()) { user ->
                dbHelper.deleteUser(user.id)
                loadUsers()
            }

            binding.rvUsers.layoutManager = LinearLayoutManager(this)
            binding.rvUsers.adapter = adapter

            binding.btnAdd.setOnClickListener {
                val name = binding.etName.text.toString()
                val email = binding.etEmail.text.toString()
                if (name.isNotEmpty() && email.isNotEmpty()) {
                    dbHelper.insertUser(name, email)
                    binding.etName.text.clear()
                    binding.etEmail.text.clear()
                    loadUsers()
                }
            }

            binding.btnClearAll.setOnClickListener {
                dbHelper.deleteAll()
                loadUsers()
            }

            loadUsers()
        }

        private fun loadUsers() {
            val users: List<User> = dbHelper.getAllUsers()
            adapter.updateData(users)
        }
    }