package com.nusa.projectxskeleton.data.source.local

import com.nusa.projectxskeleton.data.source.local.entity.comment.CommentEntity
import com.nusa.projectxskeleton.data.source.local.room.CommentDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource constructor(
    private val commentDao: CommentDao
) {
    fun getAllComments(): Flow<List<CommentEntity>> {
        return commentDao.getAllComments()
    }

    suspend fun insertComments(commentList: List<CommentEntity>) {
        return commentDao.insertComments(commentList)
    }
}