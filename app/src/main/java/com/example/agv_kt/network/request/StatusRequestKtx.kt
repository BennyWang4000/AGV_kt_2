package com.example.agv_kt.network.request


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class StatusRequestKtx(
    @SerialName("Name")
    val name: String,
    @SerialName("Cmd")
    val cmd: String,
    @SerialName("Param")
    val `param`: List<Int>
)