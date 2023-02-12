package com.example.like_counter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel

class LikeViewModel:ViewModel(){
    private val _likecount = MutableLiveData <Int>(0)
    private val _dislikecount = MutableLiveData <Int>(0)

    val likecount  : LiveData<Int>
       get() = _likecount
    val dislikecount : LiveData<Int>
        get() = _dislikecount
    //var likecount:Int = 0
    fun performLike(){
        _likecount.value  =_likecount.value!!+1

//likecount++
        }
    fun performDisLike(){
        _dislikecount.value  =_dislikecount.value!!+1

    }}


