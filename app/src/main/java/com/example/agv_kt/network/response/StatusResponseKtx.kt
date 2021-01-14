package com.example.agv_kt.network.response


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatusResponseKtx(
    @SerialName("StatusCode")
    val statusCode: Int,
    @SerialName("Config")
    val config: Config
) {
    @Serializable
    data class Config(
        @SerialName("Pos")
        val pos: Pos,
        @SerialName("RunPara")
        val runPara: RunPara,
        @SerialName("Attitude")
        val attitude: Attitude,
        @SerialName("Shelves")
        val shelves: Shelves,
        @SerialName("Status")
        val status: Status,
        @SerialName("Battery")
        val battery: String,
        @SerialName("AgvLogIndex")
        val agvLogIndex: AgvLogIndex,
        @SerialName("AgvScript")
        val agvScript: List<AgvScript>
    ) {
        @Serializable
        data class Pos(
            @SerialName("X")
            val x: Double,
            @SerialName("Y")
            val y: Double,
            @SerialName("A")
            val a: Double
        )

        @Serializable
        data class RunPara(
            @SerialName("Speed")
            val speed: Double,
            @SerialName("Acceleration")
            val acceleration: Double,
            @SerialName("Deceleration")
            val deceleration: Double,
            @SerialName("Jerk")
            val jerk: Double
        )

        @Serializable
        data class Attitude(
            @SerialName("X")
            val x: Double,
            @SerialName("Y")
            val y: Double,
            @SerialName("Yaw")
            val yaw: Double,
            @SerialName("Code")
            val code: String
        )

        @Serializable
        data class Shelves(
            @SerialName("X")
            val x: Double,
            @SerialName("Y")
            val y: Double,
            @SerialName("Yaw")
            val yaw: Double,
            @SerialName("Code")
            val code: String
        )

        @Serializable
        data class Status(
            @SerialName("State")
            val state: String,
            @SerialName("IsJogSearch")
            val isJogSearch: Boolean,
            @SerialName("IsLiftUp")
            val isLiftUp: Boolean,
            @SerialName("IsMoving")
            val isMoving: Boolean,
            @SerialName("IsAxisReady")
            val isAxisReady: Boolean,
            @SerialName("IsTurnAxisReady")
            val isTurnAxisReady: Boolean,
            @SerialName("IsLiftAxisReady")
            val isLiftAxisReady: Boolean,
            @SerialName("IsAxisMoving")
            val isAxisMoving: Boolean,
            @SerialName("IsTurnAxisMoving")
            val isTurnAxisMoving: Boolean,
            @SerialName("IsScriptCmd")
            val isScriptCmd: Boolean,
            @SerialName("IsLiftAxisMoving")
            val isLiftAxisMoving: Boolean,
            @SerialName("IsAxisCoupling")
            val isAxisCoupling: Boolean,
            @SerialName("IsTurnAxisCoupling")
            val isTurnAxisCoupling: Boolean,
            @SerialName("IsAxis3Coupling")
            val isAxis3Coupling: Boolean,
            @SerialName("IsServoON")
            val isServoON: Boolean,
            @SerialName("IsReady")
            val isReady: Boolean,
            @SerialName("IsError")
            val isError: Boolean,
            @SerialName("IsLaserStop")
            val isLaserStop: Boolean,
            @SerialName("IsChargeing")
            val isChargeing: Boolean,
            @SerialName("IsLaserEnable")
            val isLaserEnable: Boolean,
            @SerialName("IsEmergencyStop")
            val isEmergencyStop: Boolean,
            @SerialName("IsVirAxisReady")
            val isVirAxisReady: Boolean,
            @SerialName("IsLeftAxisReady")
            val isLeftAxisReady: Boolean,
            @SerialName("IsRightAxisReady")
            val isRightAxisReady: Boolean,
            @SerialName("IsLeftMotorGearIN")
            val isLeftMotorGearIN: Boolean,
            @SerialName("IsRightMotorGearIN")
            val isRightMotorGearIN: Boolean,
            @SerialName("IsScriptStart")
            val isScriptStart: Boolean,
            @SerialName("IsScriptFinish")
            val isScriptFinish: Boolean,
            @SerialName("IsScriptPause")
            val isScriptPause: Boolean,
            @SerialName("IsScriptStop")
            val isScriptStop: Boolean,
            @SerialName("IsUpdatePos")
            val isUpdatePos: Boolean
        )

        @Serializable
        data class AgvLogIndex(
            @SerialName("IsProgress")
            val isProgress: Boolean,
            @SerialName("ScriptIdx")
            val scriptIdx: Int,
            @SerialName("RunIdx")
            val runIdx: Int,
            @SerialName("ErrorIdx")
            val errorIdx: Int
        )

        @Serializable
        data class AgvScript(
            @SerialName("Type")
            val type: Int,
            @SerialName("Parameter")
            val parameter: Int,
            @SerialName("Code")
            val code: Int
        )
    }
}