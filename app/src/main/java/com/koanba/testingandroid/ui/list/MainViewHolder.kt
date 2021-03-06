package com.koanba.testingandroid.ui.list

import android.util.Log
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.koanba.testingandroid.R
import com.koanba.testingandroid.data.list.Data
import com.koanba.testingandroid.databinding.ItemListBinding

/**
 *Create by Muhammad Al Faisal
 *on 03/06/21
 */
class MainViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val itemBinding = ItemListBinding.bind(itemView)

    fun bind(data: Data) {
        itemBinding.listName.text = "${data.firstName} ${data.lastName}"
        itemBinding.listEmail.text = data.email

        Log.d("TAG", "bind: ")
        Glide.with(itemView.context)
            .asBitmap()
            .placeholder(ContextCompat.getDrawable(itemView.context, R.drawable.placeholder_circle))
            .circleCrop()
            .load(data.avatar)
            .into(itemBinding.listIcon)
    }
}