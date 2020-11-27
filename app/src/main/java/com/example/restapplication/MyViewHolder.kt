package com.example.restapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyViewHolder(view:View) : RecyclerView.ViewHolder(view) {
    var textview_title: TextView =view.findViewById(R.id.item_title);


}