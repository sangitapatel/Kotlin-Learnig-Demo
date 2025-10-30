package com.exmple.MVP.view

import com.exmple.MVP.Model.PostData

interface PostView {
    fun onShowProgress()
    fun onHideProgress()
    fun onPostsLoaded(posts: List<PostData>)
    fun onError(message: String)
}