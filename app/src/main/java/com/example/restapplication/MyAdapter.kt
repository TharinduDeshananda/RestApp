package com.example.restapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyAdapter(name_list:ArrayList<String>) : RecyclerView.Adapter<MyViewHolder>(){
    var title_array:ArrayList<String> =name_list;
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        var inflater:LayoutInflater= LayoutInflater.from(parent.context);
        var view: View =inflater.inflate(R.layout.layout_item,parent,false);

        return MyViewHolder(view);
    }

    override fun getItemCount(): Int {
        return this.title_array.size;
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.textview_title.setText(title_array.get(position));


    }
}