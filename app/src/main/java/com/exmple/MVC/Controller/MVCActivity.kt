package com.exmple.MVC.Controller

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.MVC.Api.ApiService
import com.exmple.MVC.Model.DataModel
import com.exmple.MVC.View.DataAdapter
import com.exmple.R
import com.exmple.databinding.ActivityMvcBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MVCActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvcBinding
    private lateinit var adapter: DataAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvcBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        fetchData()
    }

    private fun fetchData() {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api = retrofit.create(ApiService::class.java)
        api.getUsers().enqueue(object : Callback<List<DataModel>> {
            override fun onResponse(
                call: Call<List<DataModel>>,
                response: Response<List<DataModel>>
            ) {
                if (response.isSuccessful) {
                    val users = response.body() ?: emptyList()
                    adapter = DataAdapter(this@MVCActivity,users)
                    binding.recyclerView.adapter = adapter
                }
            }

            override fun onFailure(call: Call<List<DataModel>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}