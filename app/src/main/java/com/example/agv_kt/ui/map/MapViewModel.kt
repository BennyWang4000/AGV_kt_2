package com.example.agv_kt.ui.map

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.agv_kt.R
import com.example.agv_kt.base.BaseViewModel
import com.example.agv_kt.network.ApiResult
import com.example.agv_kt.network.response.StatusResponseGson
import com.example.agv_kt.repository.ApiRepository
import com.example.agv_kt.utils.Constant.AGV_NAME
import com.example.agv_kt.utils.cmd.Command
import com.example.agv_kt.utils.cmd.FootageCommand
import com.example.agv_kt.utils.direction.AbsDirection
import com.example.agv_kt.utils.direction.RltDirection
import com.example.agv_kt.utils.map.Map
import com.example.agv_kt.utils.map.MapItem
import com.example.agv_kt.utils.map.MapItemType
import com.example.agv_kt.utils.search.AStarSearchAlgorithm
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import retrofit2.HttpException
import timber.log.Timber
import kotlin.math.roundToInt

class MapViewModel : BaseViewModel(){
    private val apiRepository: ApiRepository by inject()

    private var lastPosition: Pair<Int, Int> = Pair(0, 0)

    private val _statusData= MutableLiveData<ApiResult<StatusResponseGson>>()
    val statusData: LiveData<ApiResult<StatusResponseGson>>
        get() = _statusData

    var vehicleYaw: Double= 0.0

    var passingNode= arrayOf<Pair<Int, Int>>()

    private val footage: MutableList<Int> = mutableListOf()

    val looksList: List<Int> = listOf(
            R.drawable.ic_baseline_looks_one_24,
            R.drawable.ic_baseline_looks_two_24,
            R.drawable.ic_baseline_looks_3_24
    )

    lateinit var startingNode: MapItem

    fun refreshMap(){
        _statusData.value?.let {
            when(it){
                is ApiResult.Success -> {
                    Map.map[lastPosition.first][lastPosition.second].type= MapItemType.Free
                    lastPosition= getPosition(it.result.config.attitude.code)
                    Map.map[lastPosition.first][lastPosition.second].type= MapItemType.AGV(1)

                    Timber.d("POSITION: ROWS(${lastPosition.first}), COLS(${lastPosition.second})")
                }
                else -> { }
            }
        }
    }

    fun btnClick(cmd: Int){
        Timber.d("FOOTAGE: $footage")
        doCommand(AGV_NAME, cmd)
    }

    fun cancel(){
        footage.clear()

        for(i in 0..6){
            for(j in 0..6){
                Map.map[i][j].cameFrom= Pair(0, 0)
                Map.map[i][j].isPass= false
            }
        }

        doCommand(AGV_NAME, Command.GETTING_ATTRIBUTE)
    }

    private var movingDistance: Int = 0
    fun setFootage() {
        footage.clear()
        movingDistance= 0
        var correctDirection: AbsDirection
        Timber.e("INITIAL DIRECTION: $vehicleYaw")
        var lastDirection = getDirection(vehicleYaw)
        Timber.e("INITIAL DIRECTION: $lastDirection")
        var rltDirection: RltDirection
        for (i in passingNode.size - 1 downTo 1) {
            val lastPos = passingNode[i - 1]
            val nextPos = passingNode[i]
            correctDirection = getDirection(lastPos, nextPos)
            Timber.d("COR DIRECTION: $correctDirection")
            rltDirection = lastDirection.getRelative(correctDirection)
//            vl cmd: Int=
            Timber.d("RLT DIRECTION: $rltDirection")
            when (rltDirection) {
                RltDirection.GoStraight ->{
                    footage.add(FootageCommand.MOVE_FORWARD_FOR_M+ movingDistance* 100)
                }
                RltDirection.TurnLeft -> {
                    footage.add(FootageCommand.TURN_LEFT_90_DEGREES)
                    footage.add(FootageCommand.MOVE_FORWARD_FOR_M+ movingDistance* 100)
                }
                RltDirection.TurnRight -> {
                    footage.add(FootageCommand.TURN_RIGHT_90_DEGREES)
                    footage.add(FootageCommand.MOVE_FORWARD_FOR_M+ movingDistance* 100)
                }
                RltDirection.TurnBack ->{
                    footage.add(FootageCommand.TURN_LEFT_180_DEGREES)
                    footage.add(FootageCommand.MOVE_FORWARD_FOR_M+ movingDistance* 100)
                }
                RltDirection.Nothing -> -1
                RltDirection.Error -> -2
            }
            lastDirection = correctDirection
        }
//        footage.add(FootageCommand.MOVE_FORWARD_FOR_M+ movingDistance* 100)
        Timber.d("COMMAND: $footage")
    }

    fun getPath(destPos: Pair<Int, Int>, startingPos: Pair<Int, Int>){
        passingNode= AStarSearchAlgorithm.aStarSearch(destPos, startingPos)
        for(i in passingNode.size-1 downTo 0){
            Map.getMapItem(passingNode[i]).isPass= true
        }
    }


    private fun getDirection(next: Pair<Int, Int>, last: Pair<Int, Int>): AbsDirection {
        Timber.e("next: $next , last: $last")
         val dir= when{
            next.first- last.first> 0 -> AbsDirection.GoDown
            next.first- last.first< 0 -> AbsDirection.GoUp
            next.second- last.second> 0 -> AbsDirection.GoRight
            next.second- last.second< 0 -> AbsDirection.GoLeft

            else -> AbsDirection.Error
        }

        Timber.e("$dir")
        return dir
    }


    fun doCommand(name: String, cmd: Int){
        viewModelScope.launch {
            flow {
                val result = apiRepository.fetchStatus(name, cmd, footage)
                Timber.d( "MAP RESULT BODY: ${result.body()}")
                if (!result.isSuccessful) throw HttpException(result)
                emit(ApiResult.success(result.body()))
            }
                    .flowOn(Dispatchers.IO)
                    .onStart { emit(ApiResult.loading()) }
                    .catch { e -> emit(ApiResult.error(e)) }
                    .onCompletion { emit(ApiResult.loaded()) }
                    .collect { _statusData.value = it }
        }
    }

    private fun getDirection(yaw: Double): AbsDirection{
        return when (yaw.roundToInt()) {
            in 316..360 -> AbsDirection.GoUp
            in 0..45 -> AbsDirection.GoUp // 0
            in 46..135 -> AbsDirection.GoRight // 90
            in 136..225 -> AbsDirection.GoDown // 180
            in 226..315 -> AbsDirection.GoLeft // 270
            else -> AbsDirection.Error
        }
    }

    private fun getPosition(code: String): Pair<Int, Int>{
        val row= code.substring(1, 2).toInt()
        val col= code.substring(4, 5).toInt()
//        lastPosition = Pair(col, row)
        return Pair(row, col)
    }

}