package com.tusxapps.idle.ui

import cafe.adriel.voyager.core.registry.screenModule
import com.tusxapps.navigation.SharedScreen

val idleScreenModule = screenModule {
    register<SharedScreen.IdleScreen> { IdleScreen(it.placeId) }
}