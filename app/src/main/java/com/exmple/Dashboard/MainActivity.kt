package com.exmple.Dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.MVC.Controller.MVCActivity
import com.exmple.MVP.MVPActivity
import com.exmple.MVVM.Coroutine.view.MVVMActivity
import com.exmple.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), ItemClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ArchitectureAdapter
    private val list = listOf(
        "MVC",
        "MVP",
        "MVVM Coroutine",
        "MVVM Without Coroutine"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArchitectureAdapter(list, this)
        binding.recyclerView.adapter = adapter
    }

    override fun onItemClick(item: String) {
        when (item) {
            "MVC" -> startActivity(Intent(this, MVCActivity::class.java))
            "MVP" -> startActivity(Intent(this, MVPActivity::class.java))
            "MVVM Coroutine" -> startActivity(Intent(this, MVVMActivity::class.java))
            "MVVM Without Coroutine" -> startActivity(Intent(this, com.exmple.MVVM.WithoutCoroutine.MVVMActivity::class.java))
        }
    }
}