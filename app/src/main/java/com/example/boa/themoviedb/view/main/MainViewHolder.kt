package com.example.boa.themoviedb.view.main

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_item.view.*

class MainViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val itemRoot: ConstraintLayout = view.itemRoot
    val trackNameTv: TextView = view.trackNameTv
    val artistNameTv: TextView = view.artistNameTv
    val trackImage: ImageView = view.trackImage
}