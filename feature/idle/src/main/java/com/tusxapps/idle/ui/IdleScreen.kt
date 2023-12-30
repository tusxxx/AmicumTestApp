package com.tusxapps.idle.ui

import android.app.Activity
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tusxapps.idle.ui.composables.IdleScreenBody
import com.tusxapps.navigation.SharedScreen
import com.tusxapps.ui.theme.AmicumTestAppTheme
import com.tusxapps.ui.utils.showDatePicker
import com.tusxapps.ui.utils.showTimePicker

class IdleScreen(private val placeId: String? = null) : Screen {
    @Composable
    override fun Content() {
        val screenModel = getScreenModel<IdleScreenModel>()
        val state by screenModel.state.collectAsState()
        val navigator = LocalNavigator.currentOrThrow
        val placesScreen = rememberScreen(provider = SharedScreen.ManualScreen)
        val context = LocalContext.current

        LaunchedEffect(Unit) {
            if (placeId != null) {
                screenModel.loadPlace(placeId)
            }
        }

        AmicumTestAppTheme {
            IdleScreenBody(
                state = state,
                onAreaClick = { navigator.push(placesScreen) },
                onOtherFieldsClick = { Toast.makeText(context, "TODO", Toast.LENGTH_SHORT).show() },
                onStartDateClick = { (context as? Activity)?.showDatePicker(screenModel::onStartDateSelect) },
                onStartTimeClick = { (context as? Activity)?.showTimePicker(screenModel::onStartTimeSelect) },
                onEndDateClick = { (context as? Activity)?.showDatePicker(screenModel::onEndDateSelect) },
                onEndTimeClick = { (context as? Activity)?.showTimePicker(screenModel::onEndTimeSelect) }
            )
        }
    }
}

