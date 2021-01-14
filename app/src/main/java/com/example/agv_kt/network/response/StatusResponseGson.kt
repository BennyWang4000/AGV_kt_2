package com.example.agv_kt.network.response


import com.google.gson.annotations.SerializedName

data class StatusResponseGson(
    @SerializedName("StatusCode")
    val statusCode: Int,
    @SerializedName("Config")
    val config: Config
) {
    data class Config(
        @SerializedName("Pos")
        val pos: Pos,
        @SerializedName("RunPara")
        val runPara: RunPara,
        @SerializedName("Attitude")
        val attitude: Attitude,
        @SerializedName("Shelves")
        val shelves: Shelves,
        @SerializedName("Status")
        val status: Status,
        @SerializedName("Battery")
        val battery: String,
        @SerializedName("AgvLogIndex")
        val agvLogIndex: AgvLogIndex,
        @SerializedName("AgvScript")
        val agvScript: List<AgvScript>
    ) {
        data class Pos(
            @SerializedName("X")
            val x: Double,
            @SerializedName("Y")
            val y: Double,
            @SerializedName("A")
            val a: Double
        )

        data class RunPara(
            @SerializedName("Speed")
            val speed: Double,
            @SerializedName("Acceleration")
            val acceleration: Double,
            @SerializedName("Deceleration")
            val deceleration: Double,
            @SerializedName("Jerk")
            val jerk: Double
        )

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

        data class Shelves(
            @SerializedName("X")
            val x: Double,
            @SerializedName("Y")
            val y: Double,
            @SerializedName("Yaw")
            val yaw: Double,
            @SerializedName("Code")
            val code: String
        )

        data class Status(
            @SerializedName("State")
            val state: String,
            @SerializedName("IsJogSearch")
            val isJogSearch: Boolean,
            @SerializedName("IsLiftUp")
            val isLiftUp: Boolean,
            @SerializedName("IsMoving")
            val isMoving: Boolean,
            @SerializedName("IsAxisReady")
            val isAxisReady: Boolean,
            @SerializedName("IsTurnAxisReady")
            val isTurnAxisReady: Boolean,
            @SerializedName("IsLiftAxisReady")
            val isLiftAxisReady: Boolean,
            @SerializedName("IsAxisMoving")
            val isAxisMoving: Boolean,
            @SerializedName("IsTurnAxisMoving")
            val isTurnAxisMoving: Boolean,
            @SerializedName("IsScriptCmd")
            val isScriptCmd: Boolean,
            @SerializedName("IsLiftAxisMoving")
            val isLiftAxisMoving: Boolean,
            @SerializedName("IsAxisCoupling")
            val isAxisCoupling: Boolean,
            @SerializedName("IsTurnAxisCoupling")
            val isTurnAxisCoupling: Boolean,
            @SerializedName("IsAxis3Coupling")
            val isAxis3Coupling: Boolean,
            @SerializedName("IsServoON")
            val isServoON: Boolean,
            @SerializedName("IsReady")
            val isReady: Boolean,
            @SerializedName("IsError")
            val isError: Boolean,
            @SerializedName("IsLaserStop")
            val isLaserStop: Boolean,
            @SerializedName("IsChargeing")
            val isChargeing: Boolean,
            @SerializedName("IsLaserEnable")
            val isLaserEnable: Boolean,
            @SerializedName("IsEmergencyStop")
            val isEmergencyStop: Boolean,
            @SerializedName("IsVirAxisReady")
            val isVirAxisReady: Boolean,
            @SerializedName("IsLeftAxisReady")
            val isLeftAxisReady: Boolean,
            @SerializedName("IsRightAxisReady")
            val isRightAxisReady: Boolean,
            @SerializedName("IsLeftMotorGearIN")
            val isLeftMotorGearIN: Boolean,
            @SerializedName("IsRightMotorGearIN")
            val isRightMotorGearIN: Boolean,
            @SerializedName("IsScriptStart")
            val isScriptStart: Boolean,
            @SerializedName("IsScriptFinish")
            val isScriptFinish: Boolean,
            @SerializedName("IsScriptPause")
            val isScriptPause: Boolean,
            @SerializedName("IsScriptStop")
            val isScriptStop: Boolean,
            @SerializedName("IsUpdatePos")
            val isUpdatePos: Boolean
        )

        data class AgvLogIndex(
            @SerializedName("IsProgress")
            val isProgress: Boolean,
            @SerializedName("ScriptIdx")
            val scriptIdx: Int,
            @SerializedName("RunIdx")
            val runIdx: Int,
            @SerializedName("ErrorIdx")
            val errorIdx: Int
        )

        data class AgvScript(
            @SerializedName("Type")
            val type: Int,
            @SerializedName("Parameter")
            val parameter: Int,
            @SerializedName("Code")
            val code: Int
        )
    }
}