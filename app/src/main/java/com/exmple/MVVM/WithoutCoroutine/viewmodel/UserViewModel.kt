package com.exmple.MVVM.WithoutCoroutine.viewmodel


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.exmple.MVVM.WithoutCoroutine.model.User
import com.exmple.MVVM.WithoutCoroutine.repository.UserRepository

class UserViewModel : ViewModel() {

    private val repository = UserRepository()
    private val _userList = MutableLiveData<List<User>>()
    val userList: LiveData<List<User>> = _userList

    fun loadUsers() {
        repository.getUsers(_userList)
    }
}