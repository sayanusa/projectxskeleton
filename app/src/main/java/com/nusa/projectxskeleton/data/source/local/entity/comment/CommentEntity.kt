package com.nusa.projectxskeleton.data.source.local.entity.comment

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "comment")
data class CommentEntity(
    @PrimaryKey
    @ColumnInfo(name="id")
    val id: Int,

    @ColumnInfo(name="body")
    val body: String,

    @ColumnInfo(name="email")
    val email: String,

    @ColumnInfo(name="name")
    val name: String,

    @ColumnInfo(name="postId")
    val postId: Int
)