package com.nusa.projectxskeleton.data.repository

import com.nusa.projectxskeleton.data.mapper.DataMapper
import com.nusa.projectxskeleton.data.source.NetworkBoundResource
import com.nusa.projectxskeleton.data.source.Resource
import com.nusa.projectxskeleton.data.source.local.LocalDataSource
import com.nusa.projectxskeleton.data.source.remote.RemoteDataSource
import com.nusa.projectxskeleton.data.source.remote.network.ApiResponse
import com.nusa.projectxskeleton.data.source.remote.response.comments.CommentResponse
import com.nusa.projectxskeleton.domain.model.comments.Comment
import com.nusa.projectxskeleton.domain.repository.ICommentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class CommentRepository constructor(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource
): ICommentRepository {

    override fun getAllComments(): Flow<Resource<List<Comment>>> =
        object: NetworkBoundResource<List<Comment>, List<CommentResponse>>() {
            override fun loadFromDB(): Flow<List<Comment>> {
                return localDataSource.getAllComments().map {
                    DataMapper.mapCommentEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<Comment>?): Boolean {
                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<CommentResponse>>> {
                return remoteDataSource.getAllComments()
            }

            override suspend fun saveCallResult(data: List<CommentResponse>) {
                val commentList = DataMapper.mapCommentResponseToEntities(data)
                return localDataSource.insertComments(commentList)
            }

        }.asFlow()
}