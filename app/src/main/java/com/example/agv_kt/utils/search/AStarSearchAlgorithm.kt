package com.example.agv_kt.utils.search

import com.example.agv_kt.utils.map.Map
import com.example.agv_kt.utils.map.MapItem
import com.example.agv_kt.utils.map.MapItemType
import timber.log.Timber
import kotlin.math.abs


private val <A, B> Pair<A, B>.rows: Int
    get() {return this.first as Int}

private val <A, B> Pair<A, B>.cols: Int
    get() {return this.second as Int}

/**
 * 演算法：
 *   open list 中選擇 f cost 最小的
 *   將該點從 open list 中移除，加到 close list
 *   將該點的鄰點加到 open list，並更改其 f cost
 * */

/**
 *       2
 *       |
 * 0 <- Node -> 1
 *       |
 *       3
 * */

object AStarSearchAlgorithm: IAStarAlgorithm {
    private lateinit var endNodePos: Pair<Int, Int>
    private lateinit var startingNodePos: Pair<Int, Int>

    private val openMap= mutableMapOf<Pair<Int, Int>, MapItem>()
    private val closeMap= mutableMapOf<Pair<Int, Int>, MapItem>()

    private val pathPos= mutableListOf<Pair<Int, Int>>()


    override fun aStarSearch(
            destPos: Pair<Int, Int>, startingPos: Pair<Int, Int>
    ): Array<Pair<Int, Int>> {
        endNodePos= destPos
        startingNodePos= startingPos
        Timber.d("STARTING POS: $startingPos")
        Timber.d("END POS: $destPos")
        openMap[startingPos] = Map.getMapItem(startingPos)
        var nextNodePos: Pair<Int, Int>
        do{
            nextNodePos= getNextNode().getPosition()
            addToOpenList(Map.getMapItem(nextNodePos))
            addToCloseList(Map.getMapItem(nextNodePos))
        } while (nextNodePos!= endNodePos)

        Timber.d("ARRIVED!") // openMap.isNotEmpty()

        do {
            pathPos.add(nextNodePos)
            nextNodePos= Map.getMapItem(nextNodePos).cameFrom
        } while (nextNodePos!= startingNodePos)
        pathPos.add(startingPos)
        Timber.d("PATH: ${pathPos.reverse().toString()}")
        return pathPos.toTypedArray().reversedArray()
    }

    private fun getNextNode(): MapItem{
        var f= Int.MAX_VALUE
        var nextNode= MapItem(0, 0, false, MapItemType.Free)
//        Timber.d("OPEN MAP: $openMap")
        openMap.forEach { item ->
            item.value.let { value ->
//                Timber.d("F_COST: ${value.F_Cost}")
                if(f > value.F_Cost){
                    f= value.F_Cost
//                    Timber.d("NEXT NODE VALUE: $value")
                    nextNode = value
//                    Timber.d("NEXT NODE: $nextNode")
                }
            }
        }
//        Timber.d("NEXT NODE POS: ${nextNode.getPosition()}")
        return nextNode
    }

    private fun addToCloseList(node: MapItem){
        openMap.remove(node.getPosition())
        closeMap[node.getPosition()] = node
//        Timber.d("addToCloseList(), CLOSE MAP: $node")
    }

    private fun addToOpenList(node: MapItem){
        val nodePos= node.getPosition()
        for(neiPos in getNeighborPos(nodePos)){
            val neiNode= Map.getMapItem(neiPos)
            calculateDistance(neiNode)
            neiNode.cameFrom= nodePos
            openMap[neiPos]= neiNode
        }
    }

    private fun calculateDistance(node: MapItem){
        node.G_Cost=
                abs(node.cols- startingNodePos.cols)+
                abs(node.rows- startingNodePos.rows)
        node.H_Cost=
                abs(node.cols- endNodePos.cols)+
                abs(node.rows- endNodePos.rows)

        node.F_Cost= node.G_Cost+ node.H_Cost
//        Timber.d("COST: ${node.getPosition()} ${node.G_Cost}, ${node.H_Cost}, ${node.F_Cost}")
    }


    private fun getNeighborPos(pos: Pair<Int, Int>): Array<Pair<Int, Int>>{
        val neighborsList= mutableListOf<Pair<Int, Int>>()
        for (i in 0..3) {
            val neiPos: Pair<Int, Int> = when (i) {
                0 -> Pair(pos.rows + 1, pos.cols)
                1 -> Pair(pos.rows - 1, pos.cols)
                2 -> Pair(pos.rows, pos.cols + 1)
                3 -> Pair(pos.rows, pos.cols - 1)
                else -> { Pair(-1, -1)}
            }
            if (isPositionValid(neiPos))
                if(!closeMap.containsKey(neiPos))
                    neighborsList.add(neiPos)
        }

//        Timber.d("NEI POS ARRAY:$pos,  $neighborsList")
        return neighborsList.toTypedArray()
    }

    private fun isPositionValid(pos: Pair<Int, Int>): Boolean{
        if(!(pos.rows> 6 || pos.rows< 0 || pos.cols> 6 || pos.cols< 0)) {
            return isNotBlock(pos)
        }
        return false
    }

    private fun isNotBlock(pos: Pair<Int, Int>) =
            Map.getMapItem(pos).type != MapItemType.Block

}