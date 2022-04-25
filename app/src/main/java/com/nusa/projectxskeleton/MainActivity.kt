package com.nusa.projectxskeleton

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.nusa.projectxskeleton.databinding.ActivityMainBinding
import com.nusa.projectxskeleton.presentation.comment.CommentActivity

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            startActivity(Intent(this, CommentActivity::class.java))
        }
    }
}