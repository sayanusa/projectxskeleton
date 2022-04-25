package com.nusa.projectxskeleton.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.nusa.projectxskeleton.data.source.local.entity.comment.CommentEntity

@Database(
    entities = [CommentEntity::class],
    version = 1,
    exportSchema = false
)

abstract class CommentDatabase: RoomDatabase() {
    abstract fun commentDao(): CommentDao
}