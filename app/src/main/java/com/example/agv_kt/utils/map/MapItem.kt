package com.example.agv_kt.utils.map

data class MapItem(
    val rows: Int,
    val cols: Int,
    var isLocatedHere: Boolean,
    var type: MapItemType,

    // distance from starting node
    var G_Cost: Int= 0,

    // distance from end node
    var H_Cost: Int= 0,

    // G cost + H cost
    var F_Cost: Int= 0,

    var isPass: Boolean= false,

    var cameFrom: Pair<Int, Int> = Pair(0, 0)

){
    fun getPosition(): Pair<Int, Int> = Pair(rows, cols)
}
