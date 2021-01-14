package com.example.agv_kt.ui.script.adapter

import timber.log.Timber


sealed class ParamListOperation {
    class Add(val param: Int, val cmdName: String) : ParamListOperation()
    class Delete(val index: Int) : ParamListOperation()
    object DeleteAll : ParamListOperation()

    fun createAdd(param: Int, cmdName: String): Add {
        Timber.d("ADD: $cmdName, $param")
        return Add(param, cmdName)
    }

}
