package com.example.like_counter

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SharedPref (context: Context) {
    private  val pref_LIKES = "SharedPref"
    private val KEY_LIKES = "Likes"
    private val sharedPref = context.getSharedPreferences("pref_LIKES",Context.MODE_PRIVATE)
    private val editor: SharedPreferences.Editor=sharedPref.edit()


    fun saveLikes(LikeCount:Int)= editor.putInt(KEY_LIKES,LikeCount).commit()
    fun  getLikes():Int= sharedPref.getInt(KEY_LIKES,0)



}