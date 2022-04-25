package com.nusa.projectxskeleton.data.mapper

import com.nusa.projectxskeleton.data.source.local.entity.comment.CommentEntity
import com.nusa.projectxskeleton.data.source.remote.response.comments.CommentResponse
import com.nusa.projectxskeleton.domain.model.comments.Comment

object DataMapper {

    fun mapCommentResponseToEntities(input: List<CommentResponse>): List<CommentEntity> {
        val commentList = ArrayList<CommentEntity>()
        input.map {
            val comment = CommentEntity(
                id = it.id,
                body = it.body,
                email = it.email,
                name = it.email,
                postId = it.postId
            )
            commentList.add(comment)
        }
        return commentList
    }

    fun mapCommentEntitiesToDomain(input: List<CommentEntity>): List<Comment> {
        return input.map {
            Comment(
                id = it.id,
                body = it.body,
                email = it.email,
                name = it.email,
                postId = it.postId
            )
        }
    }
}