package com.example.agv_kt.ui.map.adapter

import android.view.View
import android.widget.ImageButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_map.view.*

class MapViewHolder(view: View): RecyclerView.ViewHolder(view){
//    val textColumns: TextView= view.textMapItemColumns
//    val textRows: TextView= view.textMapItemRows
//    val imageVehiclePosition: ImageView = view.imgMapItemVehiclePosition
    val btnMap: ImageButton = view.btnMapItem
    val itemLayout: ConstraintLayout= view.layoutMapItem
}