package com.nusa.projectxskeleton.data.source.remote.network

import com.nusa.projectxskeleton.data.source.remote.response.comments.CommentResponse
import retrofit2.http.GET

interface ApiService {

    @GET("comments")
    suspend fun getAllComments() : List<CommentResponse>

}