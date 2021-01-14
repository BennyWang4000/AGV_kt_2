package com.example.agv_kt.ui.script

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.agv_kt.base.BaseViewModel
import com.example.agv_kt.network.ApiResult
import com.example.agv_kt.network.response.StatusResponseGson
import com.example.agv_kt.repository.ApiRepository
import com.example.agv_kt.ui.script.adapter.ParamListOperation
import com.example.agv_kt.ui.script.adapter.ScriptItem
import org.koin.core.component.inject
import timber.log.Timber

class ScriptViewModel : BaseViewModel(){

    private val apiRepository: ApiRepository by inject()

    private val _paramList= MutableLiveData<ArrayList<ScriptItem>>()
    val paramList: LiveData<ArrayList<ScriptItem>>
        get() = _paramList

    private val _scriptStatus= MutableLiveData<ApiResult<StatusResponseGson>>()
    val scriptStatus: LiveData<ApiResult<StatusResponseGson>>
        get() = _scriptStatus

    init {
        _paramList.value= arrayListOf<ScriptItem>(
                ScriptItem("TEST", 0)
        )
    }

    fun addParam(cmd: Int){
//        _paramList.value?.add(ScriptItem(application.getString(cmd.second), cmd.first))
//        _paramList.notifyObserver()
    }

    fun operateParamList(operation: ParamListOperation){
        when(operation){

            is ParamListOperation.Add -> {
                Timber.d("ADD PARAM: ${operation.param}, LIST: ${_paramList.value}")
                _paramList.value?.add(ScriptItem(operation.cmdName, operation.param))
                _paramList.notifyObserver()
            }
            is ParamListOperation.Delete -> {

            }
            is ParamListOperation.DeleteAll -> {

            }
        }
    }


    fun <T> MutableLiveData<T>.notifyObserver() {
        this.value = this.value
    }
//    fun doScript(cmd: Int){
//        viewModelScope.launch {
//            flow {
//                val result = _paramList.value?.let { apiRepository.fetchStatus(Constant.AGV_NAME, cmd.toString(), it) }
//                result?.let{
//                    Timber.d( "SCRIPT RESULT BODY: ${result.body()}")
//                    if (!result.isSuccessful) throw HttpException(result)
//                    emit(ApiResult.success(result.body()))
//                }
//            }
//                    .flowOn(Dispatchers.IO)
//                    .onStart { emit(ApiResult.loading()) }
//                    .catch { e -> emit(ApiResult.error(e)) }
//                    .onCompletion { emit(ApiResult.loaded()) }
//                    .collect { _scriptStatus.value = it }
//        }
//    }
}