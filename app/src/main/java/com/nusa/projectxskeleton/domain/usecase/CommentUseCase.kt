package com.nusa.projectxskeleton.domain.usecase

import com.nusa.projectxskeleton.data.source.Resource
import com.nusa.projectxskeleton.domain.model.comments.Comment
import kotlinx.coroutines.flow.Flow

interface CommentUseCase {
    fun getAllComments(): Flow<Resource<List<Comment>>>
}