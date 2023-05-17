package com.example.newanywhere.Retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


object RetrofitClient{
    private val baseUrl = "https://apis.data.go.kr/B551011/KorService1/"

    var gson = GsonBuilder().setLenient().create()
    private fun getRetrofit(): Retrofit = Retrofit.Builder()
        .baseUrl(baseUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
//        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    fun AreaCode_Service(): AreaCode_Interface = getRetrofit().create(AreaCode_Interface::class.java)
}