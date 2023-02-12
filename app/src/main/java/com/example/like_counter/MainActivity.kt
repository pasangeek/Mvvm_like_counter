package com.example.like_counter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels

class MainActivity : AppCompatActivity() {
    val viewModel:LikeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val likeButton:Button=findViewById(R.id.buttonLike)
        val likecounttext:TextView=findViewById(R.id.textViewlikecount)
        likeButton.setOnClickListener {

viewModel.perform_Like_count()
            likecounttext.text=viewModel.likecount.toString()

        }
    }
}