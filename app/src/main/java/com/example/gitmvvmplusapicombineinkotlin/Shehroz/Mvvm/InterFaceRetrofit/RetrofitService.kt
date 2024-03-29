package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.InterFaceRetrofit

import com.example.gitmvvmplusapicombineinkotlin.Shehroz.DataClasses.ResponseDataClassItem
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {
    @GET("users")
    fun getuserDatafromApi():Call<List<ResponseDataClassItem>>
    companion object {
        var retrofitService: RetrofitService? = null

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("https://jsonplaceholder.typicode.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }
    }
}