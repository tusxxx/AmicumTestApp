package com.tusxapps.amicumtestapp

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.tusxapps.idle.di.idleModule
import com.tusxapps.idle.ui.idleScreenModule
import com.tusxapps.manual.di.manualModule
import com.tusxapps.manual.ui.manualScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@App)
            modules(manualModule, idleModule)
        }

        ScreenRegistry {
            manualScreenModule()
            idleScreenModule()
        }
    }
}