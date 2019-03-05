package com.aranirahan.binartest.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.graphics.Color
import com.aranirahan.binartest.R
import com.aranirahan.binartest.model.Android
import kotlinx.android.synthetic.main.content_android.view.*


class AndroidAdapter(
    private val androidList: List<Android>,
    private val clickListener: (String) -> Unit
) : RecyclerView.Adapter<AndroidAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.content_android, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount() = androidList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(androidList[position])
    }

    inner class ViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

        fun bind(android: Android) {
            val v = itemView

            v.tv_name_android.text = android.name
            v.tv_code.text = android.versionCode

            if (adapterPosition % 2 == 0) v.cl_main.setBackgroundColor(Color.parseColor("#FAFAFA"))
            else v.cl_main.setBackgroundColor(Color.parseColor("#EEEEEE"))

            v.setOnClickListener { clickListener(android.name) }
        }
    }
}