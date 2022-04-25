package com.nusa.projectxskeleton.presentation.comment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.nusa.projectxskeleton.data.source.Resource
import com.nusa.projectxskeleton.databinding.ActivityCommentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class CommentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommentBinding
    private val commentAdapter = CommentAdapter()
    private val commentViewModel: CommentViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCommentBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        binding.rvComment.layoutManager = layoutManager

        commentViewModel.getAllComment().observe(this){
            when (it) {
                is Resource.Loading -> Log.i("CEK", "Loading")
                is Resource.Success -> it.data?.let { it2 ->
                    commentAdapter.setData(it2)
                    binding.rvComment.adapter = commentAdapter
                }
                is Resource.Error -> logError(it.message.toString(), "Get all comment")
            }
        }
    }

    private fun logError(error: String, step: String) {
        Log.i("CEK3", "error: $error, step: $step")
    }
}