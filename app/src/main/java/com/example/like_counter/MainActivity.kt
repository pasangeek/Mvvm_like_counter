package com.example.like_counter

import android.content.Context
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.like_counter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    val viewModel: LikeViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)


        //Data binding

        binding.likeVM = viewModel
        binding.lifecycleOwner = this
        binding.buttonLike.setOnClickListener {

            viewModel.performLike()
            //viewModel.startFromSaved(Likes)
       SharedPref(this,).saveLikes(viewModel.likecount.value?:0)
            //  binding.textViewlikecount.text = viewModel.likecount.toString()


        }

        binding.buttondislike.setOnClickListener {

            viewModel.performDisLike()
        }
        binding.getbutton.setOnClickListener{
           val savedLikes = SharedPref(this).getLikes()
            binding.textViewlikecount.text= savedLikes.toString()
                viewModel.startFromSaved(savedLikes)

        }
    }
    override fun onResume() {
        super.onResume()
        val savedLikes = SharedPref(this).getLikes()
      //  binding.textViewlikecount.text= savedLikes.toString()
        viewModel.startFromSaved(savedLikes)
  /*  override fun onPause() {
        super.onPause()

        val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        editor.apply {

            putString("LIKE", viewModel.likecount.value.toString())
            putString("DISLIKE", viewModel.dislikecount.value.toString())
            apply()
        }

    }

    override fun onResume() {
        super.onResume()
        val sharedPref = getSharedPreferences("sharedPref", Context.MODE_PRIVATE)

        val load = sharedPref.getString("LIKE", null)
        val load1 = sharedPref.getString("DISLIKE", null)

        binding.textViewlikecount.setText(load)
        binding.textViewDislikecount.setText(load1)


    } *///----observer -----
    /* val likeObserver = Observer<Int> {
             newV -> binding.textViewlikecount.text = newV.toString()
     }
     viewModel.likecount.observe(this, likeObserver)*/

}
}




