package com.tusxapps.manual.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tusxapps.manual.ui.composables.ManualScreenBody
import com.tusxapps.navigation.SharedScreen
import com.tusxapps.place.Place
import com.tusxapps.ui.spacers.mediumPadding
import com.tusxapps.ui.theme.AmicumTestAppTheme
import com.tusxapps.ui.theme.Primary
import com.tusxapps.ui.theme.Quaternary
import com.tusxapps.ui.theme.Secondary
import com.tusxapps.ui.theme.Tertiary

object ManualScreen : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<ManualScreenModel>()
        val state by screenModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        AmicumTestAppTheme {
            ManualScreenBody(
                state = state,
                onPlaceClick = navigator::navigateToIdleScreen
            )
        }
    }
}

private fun Navigator.navigateToIdleScreen(place: Place) {
    val screen = ScreenRegistry.get(provider = SharedScreen.IdleScreen(place.id))
    replaceAll(screen)
}


