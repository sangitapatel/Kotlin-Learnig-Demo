package com.exmple.MVVM.WithoutCoroutine.network

import com.exmple.MVVM.WithoutCoroutine.model.User
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>
}