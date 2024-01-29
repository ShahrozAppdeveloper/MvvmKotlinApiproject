package com.example.gitmvvmplusapicombineinkotlin.Shehroz.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gitmvvmplusapicombineinkotlin.Shehroz.DataClasses.ResponseDataClassItem
import com.example.gitmvvmplusapicombineinkotlin.databinding.SingleItemBinding

class UserAdapterClass(var datalist:List<ResponseDataClassItem>,var context: Context) :RecyclerView.Adapter<UserAdapterClass.ViewHolder>() {

    inner class ViewHolder(val binding: SingleItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SingleItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return datalist.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(datalist[position]) {
                binding.tvLangName.text = this.website
                binding.tvExp.text = this.address.street
            }
        }
    }
    fun updateData(newList: List<ResponseDataClassItem>) {
        datalist = newList
        notifyDataSetChanged()
    }
}