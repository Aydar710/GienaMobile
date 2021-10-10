package com.gina.gienamobile.presentation

import android.app.Application
import com.gina.gienamobile.data.di.dataModules
import com.gina.gienamobile.domain.di.domainModules
import com.gina.gienamobile.presentation.endgame.di.endGameModule
import com.gina.gienamobile.presentation.entername.di.enterNameModules
import com.gina.gienamobile.presentation.tutorial.di.tutorialModule
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
            modules(*mainModules, *dataModules, *domainModules, *enterNameModules, tutorialModule, endGameModule)
        }
    }
}