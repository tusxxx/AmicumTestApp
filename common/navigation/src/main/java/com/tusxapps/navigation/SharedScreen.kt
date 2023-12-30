package com.tusxapps.navigation

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class SharedScreen : ScreenProvider {
    data class IdleScreen(val placeId: String? = null) : SharedScreen()
    object ManualScreen : SharedScreen()
}
