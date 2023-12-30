package com.tusxapps.idle.di

import com.tusxapps.idle.ui.IdleScreenModel
import com.tusxapps.place.di.placesModule
import org.koin.dsl.module

val idleModule = module {
    includes(placesModule)
    factory { IdleScreenModel(get()) }
}