package com.exmple.MVC.Api

import com.exmple.MVC.Model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<DataModel>>
}