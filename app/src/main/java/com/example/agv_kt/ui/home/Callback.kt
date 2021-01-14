package com.example.agv_kt.ui.home

interface Callback {
   fun onLoading()
   fun onLoaded()
   fun onTotalCount(count: Int)
   fun onThrowable(throwable: Throwable)
}