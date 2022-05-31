package com.example.restapi

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object APIClient {
    const val BASE_URL= "http://192.168.33.65:8080/"
    fun create():APIInterface{
    val retrofit= Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

        return retrofit.create(APIInterface::class.java)
    }
}