package com.example.genres

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewAdapter (private val allList:MutableList<Genre>)
    :RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>(){

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val genreTextView : TextView = view.findViewById(R.id.vTextView)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): RecyclerViewAdapter.MyViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
                return allList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyViewHolder, position: Int) {
        holder.genreTextView.text = allList[position].name


    }

}