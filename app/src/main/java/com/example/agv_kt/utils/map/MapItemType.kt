package com.example.agv_kt.utils.map

sealed class MapItemType {
    object Block: MapItemType()
    object Free: MapItemType()
    object ChargingStation: MapItemType()
    object Stock: MapItemType()
    class AGV(id: Int): MapItemType()
}