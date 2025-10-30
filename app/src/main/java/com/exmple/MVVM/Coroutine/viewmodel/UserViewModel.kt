package com.exmple.MVVM.Coroutine.viewmodel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.exmple.MVVM.Coroutine.Model.User
import com.exmple.MVVM.Coroutine.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel : ViewModel() {
    private val repository = UserRepository()
    val users = MutableLiveData<List<User>>()
    val error = MutableLiveData<String>()

    fun fetchUsers() {
        viewModelScope.launch {
            try {
                val response = repository.getUsers()
                users.postValue(response)
            } catch (e: Exception) {
                error.postValue(e.message)
            }
        }
    }
}