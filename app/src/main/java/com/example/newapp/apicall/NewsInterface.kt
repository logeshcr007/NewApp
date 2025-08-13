package com.example.newapp.apicall

import com.example.example.Articles

import com.example.example.NewsRespone
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    @GET("everything?")
    fun getPopularNewsapi(@Query("q") qstring : String,@Query("from") fromdate:String,
                          @Query("sortBy")sortyby:String,@Query("apiKey") apikey:String) : Call<NewsRespone>
}