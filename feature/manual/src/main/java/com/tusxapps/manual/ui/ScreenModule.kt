package com.tusxapps.manual.ui

import cafe.adriel.voyager.core.registry.screenModule
import com.tusxapps.navigation.SharedScreen

val manualScreenModule = screenModule {
    register<SharedScreen.ManualScreen> { ManualScreen }
}