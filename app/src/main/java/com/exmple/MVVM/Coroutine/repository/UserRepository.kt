package com.exmple.MVVM.Coroutine.repository

import com.exmple.MVVM.Coroutine.network.RetrofitInstance

class UserRepository {
    suspend fun getUsers() = RetrofitInstance.api.getUsers()
}