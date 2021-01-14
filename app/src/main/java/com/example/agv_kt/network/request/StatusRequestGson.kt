package com.example.agv_kt.network.request


import com.google.gson.annotations.SerializedName

data class StatusRequestGson(
    @SerializedName("Name")
    val name: String,
    @SerializedName("Cmd")
    val cmd: String,
    @SerializedName("Param")
    val `param`: List<Int>
)