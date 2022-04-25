package com.nusa.projectxskeleton.domain.model.comments

data class Comment(
    val body: String,
    val email: String,
    val id: Int,
    val name: String,
    val postId: Int
)