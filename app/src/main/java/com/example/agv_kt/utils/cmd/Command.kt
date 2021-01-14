package com.example.agv_kt.utils.cmd

object Command {
    const val GETTING_ATTRIBUTE= 500
    const val SERVO_ON= 30100
    const val SERVO_OFF= 30101
    const val TURN_RIGHT_90_DEGREES= 30108
    const val TURN_RIGHT_180_DEGREES= 30109
    const val TURN_LEFT_90_DEGREES= 30110
    const val TURN_LEFT_180_DEGREES= 30111
    const val TURN_RIGHT_90_DEGREES_DISK_FIXED= 30208
    const val TURN_RIGHT_180_DEGREES_DISK_FIXED= 30209
    const val TURN_LEFT_90_DEGREES_DISK_FIXED= 30210
    const val TURN_LEFT_180_DEGREES_DISK_FIXED= 30211
    const val DISK_TURN_RIGHT_90_DEGREES= 30214
    const val DISK_TURN_RIGHT_180_DEGREES= 30215
    const val DISK_TURN_LEFT_90_DEGREES= 30216
    const val DISK_TURN_LEFT_180_DEGREES= 30217
    const val RAISING_DISK= 30218
    const val DROPPING_DISK= 30219
    const val EMERGENCY_STOP= 30310
    const val PAUSE_SCRIPT= 30312
    const val CONTINUE_SCRIPT= 30313
    const val STOP_SCRIPT= 30314
    const val MOVING_WHILE_FIXING= 30112
    const val MOVING_FORWARD_TO_CHARGING_FOR_MM= 30230
    const val LEAVING_CHARGING_STATION_FOR_MM= 30231
    const val EXECUTE_SCRIPT= 30121
}