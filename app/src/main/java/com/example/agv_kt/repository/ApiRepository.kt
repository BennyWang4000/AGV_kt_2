package com.example.agv_kt.repository

import com.example.agv_kt.network.ApiService
import com.example.agv_kt.network.response.MapResponse
import com.example.agv_kt.network.response.StatusResponseGson
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Response

class ApiRepository(
    private val apiService: ApiService,
){

    private fun <T>createJson(vararg params: Pair<String, T>) =
        JSONObject(mapOf(*params))
                .toString()
                .toRequestBody("application/json; charset=utf-8"
                        .toMediaTypeOrNull())

    suspend fun fetchStatus(name: String, cmd: Int, param: List<Int>): Response<StatusResponseGson> {
        return apiService.fetchStatus(createJson(
                "Name" to name, "Cmd" to cmd, "Param" to param))
    }

    suspend fun fetchMapByCmd500(name: String): Response<MapResponse> {
        return apiService.fetchMap(createJson(
                "Name" to name, "Cmd" to "500"))
    }
}