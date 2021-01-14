package com.example.agv_kt.di

import com.example.agv_kt.ui.directors.DirectorsViewModel
import com.example.agv_kt.ui.home.HomeViewModel
import com.example.agv_kt.ui.map.MapViewModel
import com.example.agv_kt.ui.script.ScriptViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module{
    viewModel { MapViewModel() }
    viewModel { DirectorsViewModel() }
    viewModel { HomeViewModel() }
    viewModel { ScriptViewModel() }
}