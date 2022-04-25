package com.nusa.projectxskeleton.domain.repository

import com.nusa.projectxskeleton.data.source.Resource
import com.nusa.projectxskeleton.domain.model.comments.Comment
import kotlinx.coroutines.flow.Flow

interface ICommentRepository {
    fun getAllComments(): Flow<Resource<List<Comment>>>
}