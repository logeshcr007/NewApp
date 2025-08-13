package com.example.newapp.viewmodel

import android.telecom.Call
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

import androidx.lifecycle.ViewModel
import com.example.example.Articles

import com.example.example.NewsRespone
import com.example.newapp.apicall.RetrofitInstance
import retrofit2.Callback
import retrofit2.Response

class Newsviewmodel : ViewModel() {
    private var newsLiveData = MutableLiveData<List<Articles>>()
    fun getPopularNews() {
        RetrofitInstance.api.getPopularNewsapi("tesla","69d662025-07-13","publishedAt","427df7dd2d684890a414216b03e4fe10").enqueue(object
            : Callback<NewsRespone>{

            override fun onResponse(call: retrofit2.Call<NewsRespone?>, response: Response<NewsRespone?>) {

                if (response.body()!=null){
                    newsLiveData.value = response.body()!!.articles
                }
                else{
                    return
                }

            }

            override fun onFailure(call: retrofit2.Call<NewsRespone?>, t: Throwable) {
                Log.d("TAG",t.message.toString())
            }
        })
    }


    fun observeNewsLiveData() : LiveData<List<Articles>> {
        return newsLiveData
    }
}


