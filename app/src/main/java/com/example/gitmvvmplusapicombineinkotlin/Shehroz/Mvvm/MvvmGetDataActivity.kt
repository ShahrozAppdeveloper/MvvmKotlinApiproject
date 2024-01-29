package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.gitmvvmplusapicombineinkotlin.R
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Adapter.UserAdapterClass
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.InterFaceRetrofit.RetrofitService
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.InterFaceRetrofit.RetrofitService.Companion.retrofitService
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.Repository.DataRepository
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.ViewModelClasses.UserViewModel
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.ViewModelFactory.MyViewModelFactory
import com.example.gitmvvmplusapicombineinkotlin.databinding.ActivityMvvmGetDataBinding

class MvvmGetDataActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMvvmGetDataBinding
    lateinit var userViewModel: UserViewModel
    private val retrofitService = RetrofitService.getInstance()
    private lateinit var userAdapterClass: UserAdapterClass
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mvvm_get_data)
        binding = ActivityMvvmGetDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getusersData()

    }
    private fun getusersData(){
        userAdapterClass = UserAdapterClass(emptyList(),applicationContext)
        binding.rvList.adapter=userAdapterClass
        userViewModel = ViewModelProvider(this, MyViewModelFactory(DataRepository(retrofitService))).get(UserViewModel::class.java)
        userViewModel.userList.observe(this, Observer {
            userAdapterClass.updateData(it)
        })

        userViewModel.errorMessage.observe(this, Observer {
            Toast.makeText(this,it.toString(),Toast.LENGTH_SHORT).show()
        })

        userViewModel.Getalluser()
    }
}