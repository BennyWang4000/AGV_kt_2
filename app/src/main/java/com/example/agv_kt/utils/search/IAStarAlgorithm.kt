package com.example.agv_kt.utils.search

import com.example.agv_kt.utils.map.MapItem

interface IAStarAlgorithm {
    fun aStarSearch(destPos: Pair<Int, Int>, startingPos: Pair<Int, Int>): Array<Pair<Int, Int>>

//    fun getNextNode(): MapItem
//
//    fun addToCloseList(node: MapItem)
//
//    fun addToOpenList(node: MapItem)
//
//    fun calculateDistance(node: MapItem)
//
//    fun getNeighborPos(pos: Pair<Int, Int>): Array<Pair<Int, Int>>
//
//    fun isPositionValid(pos: Pair<Int, Int>): Boolean
//
//    fun isNotBlock(pos: Pair<Int, Int>): Boolean
}