package com.example.newanywhere.Retrofit

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitClient{
    private val baseUrl = "https://apis.data.go.kr/B551011/KorService1/"

    var gson = GsonBuilder().setLenient().create()
    private fun getRetrofit(): Retrofit {

        val client = OkHttpClient.Builder()
            .connectTimeout(100, TimeUnit.SECONDS)
            .readTimeout(100, TimeUnit.SECONDS).build()

        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create(gson))
//        .addConverterFactory(ScalarsConverterFactory.create())
            .build()

        return retrofit
    }
    fun AreaCode_Service(): AreaCode_Interface = getRetrofit().create(AreaCode_Interface::class.java)
    fun Tour_Service(): Tour_Interface = getRetrofit().create(Tour_Interface::class.java)
    fun Detail_Service(): Detail_Interface = getRetrofit().create(Detail_Interface::class.java)
}