package com.example.agv_kt.utils.map

object Map {
    val map = arrayListOf<ArrayList<MapItem>>(
            arrayListOf(MapItem(0, 0, false, MapItemType.Block), MapItem(0, 1, false, MapItemType.Free), MapItem(0, 2, false, MapItemType.Free), MapItem(0, 3, false, MapItemType.Free), MapItem(0, 4, false, MapItemType.Block), MapItem(0, 5, false, MapItemType.Block), MapItem(0, 6, false, MapItemType.Block)),
            arrayListOf(MapItem(1, 0, false, MapItemType.Block), MapItem(1, 1, false, MapItemType.Block), MapItem(1, 2, false, MapItemType.Free), MapItem(1, 3, false, MapItemType.Free), MapItem(1, 4, false, MapItemType.Free), MapItem(1, 5, false, MapItemType.Free), MapItem(1, 6, false, MapItemType.Free)),
            arrayListOf(MapItem(2, 0, false, MapItemType.Block), MapItem(2, 1, false, MapItemType.Block), MapItem(2, 2, false, MapItemType.Free), MapItem(2, 3, false, MapItemType.Free), MapItem(2, 4, false, MapItemType.Free), MapItem(2, 5, false, MapItemType.Free), MapItem(2, 6, false, MapItemType.Free)),
            arrayListOf(MapItem(3, 0, false, MapItemType.Block), MapItem(3, 1, false, MapItemType.Block), MapItem(3, 2, false, MapItemType.Free), MapItem(3, 3, false, MapItemType.Free), MapItem(3, 4, false, MapItemType.Free), MapItem(3, 5, false, MapItemType.Free), MapItem(3, 6, false, MapItemType.Free)),
            arrayListOf(MapItem(4, 0, false, MapItemType.Block), MapItem(4, 1, false, MapItemType.Free), MapItem(4, 2, false, MapItemType.Free), MapItem(4, 3, false, MapItemType.Free), MapItem(4, 4, false, MapItemType.Free), MapItem(4, 5, false, MapItemType.Free), MapItem(4, 6, false, MapItemType.Free)),
            arrayListOf(MapItem(5, 0, false, MapItemType.Block), MapItem(5, 1, false, MapItemType.Free), MapItem(5, 2, false, MapItemType.Free), MapItem(5, 3, false, MapItemType.Free), MapItem(5, 4, false, MapItemType.Free), MapItem(5, 5, false, MapItemType.Free), MapItem(5, 6, false, MapItemType.Block)),
            arrayListOf(MapItem(6, 0, false, MapItemType.Block), MapItem(6, 1, false, MapItemType.Free), MapItem(6, 2, false, MapItemType.Free), MapItem(6, 3, false, MapItemType.Free), MapItem(6, 4, false, MapItemType.Free), MapItem(6, 5, false, MapItemType.ChargingStation), MapItem(6, 6, false, MapItemType.Block)),
    )

    fun getMapItem(position: Pair<Int, Int>) = map[position.first][position.second]
}