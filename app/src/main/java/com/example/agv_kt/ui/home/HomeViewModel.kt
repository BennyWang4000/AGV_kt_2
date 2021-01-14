package com.example.agv_kt.ui.home

import androidx.fragment.app.Fragment
import com.example.agv_kt.base.BaseViewModel
import com.example.agv_kt.ui.directors.DirectorsFragment
import com.example.agv_kt.ui.map.MapFragment
import com.example.agv_kt.ui.script.ScriptFragment

class HomeViewModel: BaseViewModel() {

    val fragmentList= listOf<Fragment>(ScriptFragment(), MapFragment(), DirectorsFragment())
//    val fragmentList= listOf<Fragment>(MapFragment(), DirectorsFragment())
}