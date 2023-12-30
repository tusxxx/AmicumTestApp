package com.tusxapps.manual.di

import com.tusxapps.manual.ui.ManualScreenModel
import com.tusxapps.place.di.placesModule
import org.koin.dsl.module

val manualModule = module {
    includes(placesModule)
    factory { ManualScreenModel(get()) }
}