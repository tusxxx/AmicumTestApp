package com.tusxapps.ui.composables

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import com.tusxapps.ui.theme.Primary

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmicumTopAppBar(label: String, actions: @Composable RowScope.() -> Unit = {}, onBackClick: () -> Unit = {}) {
    CenterAlignedTopAppBar(
        title = { Text(text = label) },
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(imageVector = Icons.Filled.KeyboardArrowLeft, contentDescription = null, tint = Color.White)
            }
        },
        actions = actions,
        colors = TopAppBarDefaults.smallTopAppBarColors(containerColor = Primary, titleContentColor = Color.White),
    )
}