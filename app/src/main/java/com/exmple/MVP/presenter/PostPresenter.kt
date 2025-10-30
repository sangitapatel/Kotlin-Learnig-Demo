package com.exmple.MVP.presenter

import com.exmple.MVP.Model.NetworkService
import com.exmple.MVP.Model.PostData
import com.exmple.MVP.view.PostView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class PostPresenter(private val view: PostView) {
    private val retrofit = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private val api = retrofit.create(NetworkService::class.java)

    fun loadPosts() {
        view.onShowProgress()
        api.fetchAllPosts().enqueue(object : Callback<List<PostData>> {
            override fun onResponse(call: Call<List<PostData>>, response: Response<List<PostData>>) {
                view.onHideProgress()
                if (response.isSuccessful && response.body() != null) {
                    view.onPostsLoaded(response.body()!!)
                } else {
                    view.onError("Server Error: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<List<PostData>>, t: Throwable) {
                view.onHideProgress()
                view.onError("Failed: ${t.message}")
            }
        })
    }
}