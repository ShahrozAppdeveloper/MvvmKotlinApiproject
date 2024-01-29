package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.Repository

import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.InterFaceRetrofit.RetrofitService

class DataRepository  constructor(val retrofitService: RetrofitService){
    fun getAllusers() = retrofitService.getuserDatafromApi()

}