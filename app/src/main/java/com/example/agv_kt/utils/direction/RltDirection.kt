package com.example.agv_kt.utils.direction

sealed class RltDirection{
    object GoStraight: RltDirection()
    object TurnLeft: RltDirection()
    object TurnRight: RltDirection()
    object TurnBack: RltDirection()

    object Nothing: RltDirection()

    object Error: RltDirection()
}
