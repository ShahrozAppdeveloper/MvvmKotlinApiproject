package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.ViewModelClasses

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Adapter.UserAdapterClass
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.DataClasses.ResponseDataClassItem
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.Repository.DataRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UserViewModel constructor(val dataRepository: DataRepository):ViewModel() {
    val userList = MutableLiveData<List<ResponseDataClassItem>>()
    val errorMessage = MutableLiveData<String>()
    fun Getalluser(){
        val response = dataRepository.getAllusers()
        response.enqueue(object : Callback<List<ResponseDataClassItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataClassItem>>,
                response: Response<List<ResponseDataClassItem>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data!=null){
                        userList.postValue(data)
                    }
                    // Process the data as needed
                }
            }

            override fun onFailure(call: Call<List<ResponseDataClassItem>>, t: Throwable) {
               errorMessage.postValue(t.message)
            }
        })
    }
}