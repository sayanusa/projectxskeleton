package com.nusa.projectxskeleton.presentation.comment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nusa.projectxskeleton.R
import com.nusa.projectxskeleton.databinding.ListCommentBinding
import com.nusa.projectxskeleton.domain.model.comments.Comment

class CommentAdapter() : RecyclerView.Adapter<CommentAdapter.CommentViewHolder>() {

    var listComment = ArrayList<Comment>()

    fun setData(newListComment: List<Comment>?) {
        if (newListComment == null) return
        listComment.clear()
        listComment.addAll(newListComment)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_comment, parent, false)

        return CommentViewHolder( view )
    }

    override fun onBindViewHolder(holder: CommentViewHolder, position: Int) {
        val dataComment = listComment[position]
        holder.bind(dataComment)
    }

    override fun getItemCount(): Int {
        return listComment.size
    }

    class CommentViewHolder(view: View): RecyclerView.ViewHolder( view ) {
        private val binding = ListCommentBinding.bind( view )
        fun bind(data: Comment){
            binding.tvPostId.text = data.postId.toString()
            binding.tvNameValue.text = data.name
            binding.tvCommentValue.text = data.body
        }
    }
}