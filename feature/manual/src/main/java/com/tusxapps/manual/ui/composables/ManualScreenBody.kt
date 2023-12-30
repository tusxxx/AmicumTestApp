package com.tusxapps.manual.ui.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.tusxapps.manual.ui.ManualScreenModel
import com.tusxapps.place.Place
import com.tusxapps.ui.composables.AmicumTopAppBar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun ManualScreenBody(state: ManualScreenModel.State, onPlaceClick: (Place) -> Unit) {
    val navigator = LocalNavigator.currentOrThrow
    Scaffold(
        topBar = { AmicumTopAppBar(label = "Выбрать участок", onBackClick = navigator::pop) },
        content = {
            Box(
                modifier = Modifier
                    .padding(it)
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
            ) {
                Column {
                    state.places.forEach {
                        PlaceItem(place = it, level = 0, onPlaceClick = onPlaceClick)
                    }
                }
            }
        }
    )
}
