package com.tusxapps.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tusxapps.ui.spacers.MediumSpacer
import com.tusxapps.ui.spacers.mediumPadding

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AmicumCard(
    // Не знаю бизнес задачи, поэтому такой нейминг.
    upperText: String,
    lowerText: String?,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    ElevatedCard(
        modifier = modifier,
        onClick = onClick,
        elevation = CardDefaults.elevatedCardElevation(8.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(mediumPadding),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(text = upperText, style = MaterialTheme.typography.bodyMedium)
                lowerText?.let {
                    MediumSpacer()
                    Text(text = it, style = MaterialTheme.typography.bodyLarge)
                }
            }
            Icon(imageVector = Icons.Filled.KeyboardArrowRight, contentDescription = null)
        }
    }
}