package com.example.like_counter

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.example.like_counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: LikeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.likeVM = viewModel
        binding.buttonLike.setOnClickListener {

            viewModel.performLike()
            //  binding.textViewlikecount.text = viewModel.likecount.toString()

        }

        //----observer -----
        val likeObserver = Observer<Int> {
                newV -> binding.textViewlikecount.text = newV.toString()
        }
        viewModel.likecount.observe(this, likeObserver)

}
}