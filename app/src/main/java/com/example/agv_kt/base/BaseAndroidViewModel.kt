package com.example.agv_kt.base

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import org.koin.core.component.KoinComponent

abstract class BaseAndroidViewModel(application: Application): AndroidViewModel(application), KoinComponent {
}