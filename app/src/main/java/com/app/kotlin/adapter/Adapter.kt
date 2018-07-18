package com.app.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.app.kotlin.R
import kotlinx.android.synthetic.main.adapter_.view.*

internal class Adapter(var listCommnet: ArrayList<String>) : RecyclerView.Adapter<Adapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.adapter_, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvAnimalType.text= listCommnet[position]
    }

    override fun getItemCount(): Int {
        return listCommnet.size
    }

    internal inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvAnimalType = itemView.textView!!
    }
}
