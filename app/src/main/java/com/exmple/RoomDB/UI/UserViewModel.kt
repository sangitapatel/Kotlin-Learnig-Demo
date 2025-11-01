package com.exmple.RoomDB.UI


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exmple.RoomDB.Data.User
import com.exmple.RoomDB.Data.UserRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class UserViewModel(private val repo: UserRepository) : ViewModel() {
    val users = repo.users.stateIn(viewModelScope, SharingStarted.Lazily, emptyList())

    fun addUser(name: String, email: String) = viewModelScope.launch {
        repo.insert(User(name = name, email = email))
    }

    fun deleteAll() = viewModelScope.launch {
        repo.deleteAll()
    }
}