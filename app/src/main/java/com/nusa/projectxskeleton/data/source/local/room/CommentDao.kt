package com.nusa.projectxskeleton.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nusa.projectxskeleton.data.source.local.entity.comment.CommentEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {
    @Query("select * from comment")
    fun getAllComments(): Flow<List<CommentEntity>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertComments(comment: List<CommentEntity>)
}