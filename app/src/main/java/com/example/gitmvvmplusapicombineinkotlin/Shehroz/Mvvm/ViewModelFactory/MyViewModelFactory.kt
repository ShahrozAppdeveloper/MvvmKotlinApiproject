package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.ViewModelFactory

import android.widget.ViewSwitcher.ViewFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.Repository.DataRepository
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.Mvvm.ViewModelClasses.UserViewModel

class MyViewModelFactory constructor(val dataRepository: DataRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return if (modelClass.isAssignableFrom(UserViewModel::class.java)) {
            UserViewModel(this.dataRepository) as T
        } else {
            throw IllegalArgumentException("ViewModel Not Found")
        }
    }

}