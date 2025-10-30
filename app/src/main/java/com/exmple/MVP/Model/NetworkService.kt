package com.exmple.MVP.Model

import retrofit2.Call
import retrofit2.http.GET

interface NetworkService {
    @GET("posts")
    fun fetchAllPosts(): Call<List<PostData>>
}