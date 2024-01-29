package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.gitmvvmplusapicombineinkotlin.R
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Adapter.UserAdapterClass
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.DataClasses.ResponseDataClassItem
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.RetrofitCilent.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetDataFromApiActivity : AppCompatActivity() {
    private lateinit var adapterClass: UserAdapterClass
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_data_from_api)

        getDataFromApi()
    }
    private fun getDataFromApi(){
        recyclerView =findViewById(R.id.rv_list)
        val call = RetrofitClient.ApiClient.apiService.getuserInfo()
        call.enqueue(object : Callback<List<ResponseDataClassItem>> {
            override fun onResponse(
                call: Call<List<ResponseDataClassItem>>,
                response: Response<List<ResponseDataClassItem>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()
                    if (data!=null){
                        adapterClass = UserAdapterClass(data!!)
                        recyclerView.adapter=adapterClass
                    }
                    // Process the data as needed
                }else{
                    Toast.makeText(applicationContext,"Data is Null",Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ResponseDataClassItem>>, t: Throwable) {
                Toast.makeText(applicationContext,""+t.message,Toast.LENGTH_SHORT).show()
            }
        })
    }
}