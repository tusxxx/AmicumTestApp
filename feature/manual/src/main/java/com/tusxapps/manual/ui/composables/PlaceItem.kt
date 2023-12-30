package com.tusxapps.manual.ui.composables


import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.tusxapps.place.Place
import com.tusxapps.ui.spacers.mediumPadding
import com.tusxapps.ui.theme.Primary
import com.tusxapps.ui.theme.Quaternary
import com.tusxapps.ui.theme.Secondary
import com.tusxapps.ui.theme.Tertiary

@Composable
internal fun PlaceItem(
    place: Place,
    modifier: Modifier = Modifier,
    level: Int = 0,
    onPlaceClick: (Place) -> Unit = {}
) {
    var isOpened by remember { mutableStateOf(false) }
    val iconVector = remember(isOpened, place) {
        when {
            place.internalPlaces.isEmpty() -> null
            isOpened -> Icons.Filled.KeyboardArrowDown
            else -> Icons.Filled.KeyboardArrowRight
        }
    }
    val color by animateColorAsState(
        targetValue = if (isOpened) Primary else Secondary,
        label = "asd"
    )
    
    Column(modifier.wrapContentHeight()) {
        Row(
            modifier
                .fillMaxWidth()
                .background(color = color)
                .border(1.dp, Color.White)
                .clickable(onClick = { onPlaceClick(place) }),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            repeat(level - 1) {
                Spacer(
                    modifier = Modifier
                        .width(mediumPadding)
                        .height(48.dp)
                        .fillMaxHeight()
                        .background(Quaternary)
                )
            }

            if (level > 0) {
                Spacer(
                    modifier = Modifier
                        .width(mediumPadding)
                        .height(48.dp)
                        .fillMaxHeight()
                        .background(Tertiary)
                )
            }

            Text(text = place.name, Modifier.padding(start = mediumPadding))

            Spacer(modifier = Modifier.weight(1f))

            IconButton(
                onClick = { isOpened = !isOpened },
                enabled = iconVector != null // Для того, чтобы паддинг был везде одинаковый
            ) {
                iconVector?.let {
                    Icon(
                        imageVector = it,
                        contentDescription = null
                    )
                }
            }
        }

        AnimatedVisibility(isOpened) {
            PlaceList(place = place, level = level + 1, onPlaceClick = onPlaceClick)
        }
    }
}