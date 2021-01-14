package com.example.agv_kt.ui.map.adapter

import android.annotation.SuppressLint
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.example.agv_kt.R
import com.example.agv_kt.ui.map.MapViewModel
import com.example.agv_kt.utils.Constant
import com.example.agv_kt.utils.cmd.Command
import com.example.agv_kt.utils.map.Map
import com.example.agv_kt.utils.map.MapItem
import com.example.agv_kt.utils.map.MapItemType

class MapPagingAdapter(
        private val viewModel: MapViewModel
): PagingDataAdapter<MapItem, MapViewHolder>(diffCallback) {
//): RecyclerView.Adapter<MapViewHolder>(){

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<MapItem>() {
            override fun areItemsTheSame(
                    oldItem: MapItem,
                    newItem: MapItem
            ): Boolean {
                return oldItem.cols == newItem.cols && oldItem.rows == newItem.rows
            }

            override fun areContentsTheSame(
                    oldItem: MapItem,
                    newItem: MapItem
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(
                R.layout.item_map,
                parent,
                false)
        return MapViewHolder(view)
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MapViewHolder, position: Int) {
        val rows= position% 7
        val cols= position/ 7
//        val itemData= viewModel.mapData[cols][rows]
        val itemData: MapItem= Map.map[cols][rows]



        when(itemData.type){
            is MapItemType.Free -> { }

            is MapItemType.Block -> {
                holder.btnMap.setBackgroundColor(Color.LTGRAY)
                holder.btnMap.isClickable= false
            }
            is MapItemType.ChargingStation -> {
                holder.btnMap.setBackgroundColor(Color.YELLOW)
            }
            is MapItemType.Stock -> {
                holder.btnMap.setBackgroundColor(Color.MAGENTA)
            }
            is MapItemType.AGV -> {
                holder.btnMap.setBackgroundColor(Color.CYAN)
                viewModel.startingNode= itemData
            }
//            MapItemType.AGV(3) -> {
//
//            }
        }

        if(itemData.isPass){
            holder.btnMap.setBackgroundColor(Color.BLUE)
        }

        holder.btnMap.setOnClickListener {
//            viewModel.footageList.add(itemData)
//            it.setBackgroundResource(viewModel.looksList[viewModel.selection++])
            viewModel.getPath(itemData.getPosition(), viewModel.startingNode.getPosition())
            viewModel.setFootage()

            viewModel.doCommand(Constant.AGV_NAME, Command.GETTING_ATTRIBUTE)
            notifyDataSetChanged()
        }

    }


    override fun getItemCount(): Int = Constant.AMOUNT_OF_MAP_BLOCK
}