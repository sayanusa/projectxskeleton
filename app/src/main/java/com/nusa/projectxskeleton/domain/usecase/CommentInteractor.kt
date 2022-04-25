package com.nusa.projectxskeleton.domain.usecase

import com.nusa.projectxskeleton.data.source.Resource
import com.nusa.projectxskeleton.domain.model.comments.Comment
import com.nusa.projectxskeleton.domain.repository.ICommentRepository
import kotlinx.coroutines.flow.Flow

class CommentInteractor constructor(private val commentRepositoryInterface: ICommentRepository): CommentUseCase {
    override fun getAllComments(): Flow<Resource<List<Comment>>> {
        return commentRepositoryInterface.getAllComments()
    }
}