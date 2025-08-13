package com.example.newapp.apicall

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
//https://newsapi.org/v2/everything?q=tesla&from=2025-07-13&sortBy=publishedAt&apiKey=427df7dd2d684890a414216b03e4fe10

object RetrofitInstance {
    val api : NewsInterface by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsInterface::class.java)
    }
}