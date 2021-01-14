package com.example.agv_kt.network

import com.example.agv_kt.network.request.StatusRequestGson
import com.example.agv_kt.network.request.StatusRequestKtx
import com.example.agv_kt.network.response.MapResponse
import com.example.agv_kt.network.response.StatusResponseGson
import com.example.agv_kt.network.response.StatusResponseKtx
import com.google.gson.JsonObject
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.*


interface ApiService {

    @Headers("Content-Type: application/json")
//    @POST("Test/")
    @POST("SendAgvCmd")
    suspend fun fetchStatus(@Body request: RequestBody): Response<StatusResponseGson>

    @Headers("Content-Type: application/json")
//    @POST("Test/")
    @POST("SendAgvCmd")
    suspend fun fetchMap(@Body request: RequestBody): Response<MapResponse>

    /**
     * Request example
     * {'Name':'ITRI_3-4','Cmd':'500','Param':[1.2.3]}
     * */

    /**
     * Response example
     * {"StatusCode":0,"Config":{"Pos":{"X":2.0,"Y":1005.0,"A":0.3},"RunPara":{"Speed":0.0,"Acceleration":0.0,"Deceleration":0.0,"Jerk":0.0},"Attitude":{"X":-5.0,"Y":3.0,"Yaw":180.5,"Code":"040020"},"Shelves":{"X":8.0,"Y":3.0,"Yaw":89.3,"Code":"000000"},"Status":{"State":"null","IsJogSearch":false,"IsLiftUp":false,"IsMoving":false,"IsAxisReady":false,"IsTurnAxisReady":false,"IsLiftAxisReady":false,"IsAxisMoving":false,"IsTurnAxisMoving":false,"IsScriptCmd":false,"IsLiftAxisMoving":false,"IsAxisCoupling":false,"IsTurnAxisCoupling":false,"IsAxis3Coupling":false,"IsServoON":true,"IsReady":false,"IsError":false,"IsLaserStop":false,"IsChargeing":false,"IsLaserEnable":false,"IsEmergencyStop":false,"IsVirAxisReady":false,"IsLeftAxisReady":false,"IsRightAxisReady":false,"IsLeftMotorGearIN":false,"IsRightMotorGearIN":false,"IsScriptStart":false,"IsScriptFinish":false,"IsScriptPause":false,"IsScriptStop":false,"IsUpdatePos":false},"Battery":"Disconnect","AgvLogIndex":{"IsProgress":false,"ScriptIdx":0,"RunIdx":0,"ErrorIdx":0},"AgvScript":[{"Type":330,"Parameter":0,"Code":330},{"Type":7000,"Parameter":550,"Code":7550},{"Type":6000,"Parameter":600,"Code":6600},{"Type":10000,"Parameter":10,"Code":11000},{"Type":500,"Parameter":10,"Code":510}]}}
     * */

//    companion object{
//        operator fun invoke(
//            interceptor: Interceptor
//        ): ApiService{
//                val okHttpClient = OkHttpClient.Builder()
//                .build()
//
//            return Retrofit.Builder()
//                .client(okHttpClient)
//                .baseUrl("https://192.168.101.234:50100/AGV/SendAgvCmd")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build()
//                .create(ApiService::class.java)
//        }
//    }
}