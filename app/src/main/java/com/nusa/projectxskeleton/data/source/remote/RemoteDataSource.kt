package com.nusa.projectxskeleton.data.source.remote

import android.util.Log
import com.nusa.projectxskeleton.data.source.remote.network.ApiResponse
import com.nusa.projectxskeleton.data.source.remote.network.ApiService
import com.nusa.projectxskeleton.data.source.remote.response.comments.CommentResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource (private val apiService: ApiService) {

    suspend fun getAllComments(): Flow<ApiResponse<List<CommentResponse>>> {
        return flow{
            try {
                val response = apiService.getAllComments()
                if(response.isNotEmpty()){
                    emit(ApiResponse.Success(response))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception){
                emit(ApiResponse.Error(e.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }

}