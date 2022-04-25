package com.nusa.projectxskeleton.presentation.comment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.nusa.projectxskeleton.data.source.Resource
import com.nusa.projectxskeleton.domain.model.comments.Comment
import com.nusa.projectxskeleton.domain.usecase.CommentUseCase

class CommentViewModel (private val commentUseCase: CommentUseCase) : ViewModel() {

    fun getAllComment(): LiveData<Resource<List<Comment>>>{
        return commentUseCase.getAllComments().asLiveData()
    }
}