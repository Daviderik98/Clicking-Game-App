package com.example.navigtwo.API_part

import retrofit2.Call
import retrofit2.http.GET

interface WordApi {
    @GET("/word")
    fun getTheWord(): Call<List<String>>
}