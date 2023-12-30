package com.tusxapps.manual.ui.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.tusxapps.place.Place

@Composable
internal fun PlaceList(place: Place, level: Int, onPlaceClick: (Place) -> Unit = {}) {
    Column {
        place.internalPlaces.forEach {
            PlaceItem(place = it, level = level, onPlaceClick = onPlaceClick)
        }
    }
}