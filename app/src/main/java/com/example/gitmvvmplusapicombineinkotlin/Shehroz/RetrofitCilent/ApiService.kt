package com.example.gitmvvmplusapicombineinkotlin.Shehroz.RetrofitCilent

import com.example.gitmvvmplusapicombineinkotlin.Shehroz.DataClasses.ResponseDataClassItem
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("users")
    fun getuserInfo() : Call<List<ResponseDataClassItem>>
}