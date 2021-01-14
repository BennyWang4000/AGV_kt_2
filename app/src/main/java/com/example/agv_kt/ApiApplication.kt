package com.example.agv_kt

import android.app.Application
import com.example.agv_kt.di.apiModule
import com.example.agv_kt.di.appModule
import com.example.agv_kt.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import timber.log.Timber

class ApiApplication : Application(){
    companion object {
        lateinit var self: Application
        fun applicationContext(): Application {
            return self
        }
    }

    init {
        self = this
    }
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }

        val module = listOf(
                appModule,
                apiModule,
//                dbModule,
                viewModelModule
        )

        startKoin {
            androidLogger()
            androidContext(this@ApiApplication)
            modules(module)
        }
    }
}