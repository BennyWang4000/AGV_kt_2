package com.example.agv_kt.network.response


import com.google.gson.annotations.SerializedName

data class MapResponse(
    @SerializedName("StatusCode")
    val statusCode: Int,
    @SerializedName("Config")
    val config: Config
) {
    data class Config(
        @SerializedName("Attitude")
        val attitude: Attitude
    ) {
        data class Attitude(
            @SerializedName("X")
            val x: Double,
            @SerializedName("Y")
            val y: Double,
            @SerializedName("Yaw")
            val yaw: Double,
            @SerializedName("Code")
            val code: String
        )
    }
}