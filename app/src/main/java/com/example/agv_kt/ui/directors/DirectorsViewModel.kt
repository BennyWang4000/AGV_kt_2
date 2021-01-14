package com.example.agv_kt.ui.directors

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.agv_kt.base.BaseViewModel
import com.example.agv_kt.network.ApiResult
import com.example.agv_kt.network.response.StatusResponseGson
import com.example.agv_kt.repository.ApiRepository
import com.example.agv_kt.utils.Constant
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import org.koin.core.component.inject
import retrofit2.HttpException
import timber.log.Timber

class DirectorsViewModel: BaseViewModel() {
    private val apiRepository: ApiRepository by inject()

    private val _statusData= MutableLiveData<ApiResult<StatusResponseGson>>()
    val statusData: LiveData<ApiResult<StatusResponseGson>>
        get() = _statusData

    fun clickCommand(cmd: Int) {
        Timber.e("COMMAND: $cmd")

        getStatus(Constant.AGV_NAME, cmd)
    }

    fun clickCommand(cmd: Int, param: List<Int> = listOf()){
        Timber.e( "COMMAND: $cmd")

        getStatus(Constant.AGV_NAME, cmd, param)

//        when(cmd){
//            Command.MOVING_WHILE_FIXING -> getStatus(Constant.AGV_NAME, cmd.toString(), param)
//            Command.TURNLEFT -> getStatus(Constant.AGV_NAME, Command.TURN_LEFT_90_DEGREES.toString(), listOf())
//        }
    }

    fun powerUp(){
        getStatus(Constant.AGV_NAME, 30100, listOf())
    }

    fun getStatus(name: String, cmd: Int, param: List<Int> = listOf()){
        viewModelScope.launch {
            flow {
                val result = apiRepository.fetchStatus(name, cmd, param)
                Timber.d( "RESULT BODY: ${result.body()}")
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
}