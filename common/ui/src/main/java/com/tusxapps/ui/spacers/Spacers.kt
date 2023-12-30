package com.tusxapps.ui.spacers

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun ColumnScope.SmallSpacer() {
    Spacer(modifier = Modifier.height(smallPadding))
}

@Composable
fun ColumnScope.MediumSpacer() {
    Spacer(modifier = Modifier.height(mediumPadding))
}

@Composable
fun ColumnScope.LargeSpacer() {
    Spacer(modifier = Modifier.height(largePadding))
}

@Composable
fun RowScope.SmallSpacer() {
    Spacer(modifier = Modifier.height(smallPadding))
}

@Composable
fun RowScope.MediumSpacer() {
    Spacer(modifier = Modifier.height(mediumPadding))
}

@Composable
fun RowScope.LargeSpacer() {
    Spacer(modifier = Modifier.height(largePadding))
}


