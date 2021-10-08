package com.gina.gienamobile.presentation

import android.app.Application
import com.gina.gienamobile.data.di.dataModules
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(applicationContext)
            modules(*mainModules, *dataModules)
        }
    }
}