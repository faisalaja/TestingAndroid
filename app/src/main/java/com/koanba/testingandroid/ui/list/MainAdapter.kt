package com.koanba.testingandroid.ui.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.koanba.testingandroid.R
import com.koanba.testingandroid.data.list.Data

/**
 *Create by Muhammad Al Faisal
 *on 03/06/21
 */
class MainAdapter(private val dataList: List<Data>) : RecyclerView.Adapter<MainViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return MainViewHolder(inflater.inflate(R.layout.item_list, parent, false))
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        holder.bind(dataList[position])
    }

    override fun getItemCount() = if (dataList.isNotEmpty()) dataList.size else 0
}