package com.example.like_counter

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.like_counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel:LikeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val  binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

            // val likeButton:Button=findViewById(R.id.buttonLike)
        //val likecounttext:TextView=findViewById(R.id.textViewlikecount)
        binding.buttonLike.setOnClickListener {

viewModel.perform_Like_count()
            binding.textViewlikecount.text=viewModel.likecount.toString()

        }
    }
}