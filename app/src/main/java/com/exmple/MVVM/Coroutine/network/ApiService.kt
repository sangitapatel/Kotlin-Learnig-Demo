package com.exmple.MVVM.Coroutine.network
import com.exmple.MVVM.Coroutine.Model.User
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}