package com.exmple.MVP

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.exmple.MVP.presenter.PostPresenter
import com.exmple.R
import com.exmple.databinding.ActivityMvpBinding
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.exmple.MVP.Model.PostData
import com.exmple.MVP.adapter.PostListAdapter
import com.exmple.MVP.view.PostView

class MVPActivity : AppCompatActivity() , PostView {
    private lateinit var binding: ActivityMvpBinding
    private lateinit var presenter: PostPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMvpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = PostPresenter(this)
        presenter.loadPosts()
    }

    override fun onShowProgress() {
        binding.progressBar.visibility = View.VISIBLE
    }

    override fun onHideProgress() {
        binding.progressBar.visibility = View.GONE
    }

    override fun onPostsLoaded(posts: List<PostData>) {
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MVPActivity)
            adapter = PostListAdapter(posts)
        }
    }
    override fun onError(message: String) {
        binding.tvError.text = message
        binding.tvError.visibility = View.VISIBLE
    }
}