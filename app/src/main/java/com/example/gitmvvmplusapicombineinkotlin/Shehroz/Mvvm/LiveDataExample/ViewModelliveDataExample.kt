package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.LiveDataExample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModelliveDataExample:ViewModel() {
    var data =MutableLiveData<String>()
    var value=MutableLiveData<Int>()
    val readdata:LiveData<String> get() = data
    val readvalue:LiveData<Int> get() = value

    fun setplus(input:Int){
        data.value = (data.value)?.plus(input)
    }
    fun setminus(input:Int){
        data.value = data.value?.plus(input)
    }


}