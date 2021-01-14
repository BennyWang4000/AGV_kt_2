package com.example.agv_kt.utils.direction

sealed class AbsDirection{
    object GoUp : AbsDirection()
    object GoDown: AbsDirection()
    object GoLeft : AbsDirection()
    object GoRight : AbsDirection()

    object Nothing: AbsDirection()
    object Error: AbsDirection()



    fun getRelative(nextDirection: AbsDirection): RltDirection{
        return when(this){
            nextDirection ->  RltDirection.GoStraight
            GoUp -> {
                 when(nextDirection){
                     GoLeft ->  RltDirection.TurnLeft
                     GoRight ->  RltDirection.TurnRight
                     GoDown -> RltDirection.TurnBack

                     else ->  RltDirection.Error
                }
            }
            GoDown -> {
                 when(nextDirection){
                     GoLeft -> RltDirection.TurnRight
                     GoRight -> RltDirection.TurnLeft
                     GoUp -> RltDirection.TurnBack

                     else ->  RltDirection.Error
                }
            }
            GoLeft -> {
                 when(nextDirection){
                     GoUp -> RltDirection.TurnRight
                     GoDown -> RltDirection.TurnLeft
                     GoRight -> RltDirection.TurnBack

                     else ->  RltDirection.Error
                }
            }
            GoRight -> {
                when(nextDirection){
                    GoUp -> RltDirection.TurnLeft
                    GoDown -> RltDirection.TurnRight
                    GoLeft -> RltDirection.TurnBack

                    else ->  RltDirection.Error
                }
            }
            else ->  RltDirection.Error
        }
    }
}
