package com.tusxapps.idle.ui.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.tusxapps.idle.R
import com.tusxapps.idle.ui.IdleScreenModel
import com.tusxapps.ui.composables.AmicumCard
import com.tusxapps.ui.composables.AmicumTopAppBar
import com.tusxapps.ui.spacers.mediumPadding
import java.time.format.DateTimeFormatter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
internal fun IdleScreenBody(
    state: IdleScreenModel.State,
    onAreaClick: () -> Unit,
    onOtherFieldsClick: () -> Unit,
    onStartDateClick: () -> Unit,
    onStartTimeClick: () -> Unit,
    onEndDateClick: () -> Unit,
    onEndTimeClick: () -> Unit
) {
    Scaffold(
        topBar = {
            AmicumTopAppBar(
                label = "Добавить простой",
                onBackClick = {}
            )
        },
        content = {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(mediumPadding)
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.spacedBy(mediumPadding)
            ) {
                AmicumCard(
                    upperText = stringResource(R.string.area),
                    lowerText = state.placeName,
                    modifier = Modifier,
                    onClick = onAreaClick
                )
                AmicumCard(upperText = stringResource(R.string.place), lowerText = null, onClick = onOtherFieldsClick)
                Row(horizontalArrangement = Arrangement.spacedBy(mediumPadding)) {
                    AmicumCard(
                        upperText = stringResource(R.string.begin_date),
                        lowerText = state.startDateTime?.format(
                            DateTimeFormatter.ofPattern("dd.MM.yyyy")
                        ),
                        onClick = onStartDateClick,
                        modifier = Modifier.weight(1f)
                    )
                    AmicumCard(
                        upperText = stringResource(R.string.begin_time),
                        lowerText = state.startDateTime?.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        ),
                        onClick = onStartTimeClick,
                        modifier = Modifier.weight(1f)
                    )
                }
                Row(horizontalArrangement = Arrangement.spacedBy(mediumPadding)) {
                    AmicumCard(
                        upperText = stringResource(R.string.end_date),
                        lowerText = state.endDateTime?.format(
                            DateTimeFormatter.ofPattern("dd.MM.yyyy")
                        ),
                        onClick = onEndDateClick,
                        modifier = Modifier.weight(1f)
                    )
                    AmicumCard(
                        upperText = stringResource(R.string.end_time),
                        lowerText = state.endDateTime?.format(
                            DateTimeFormatter.ofPattern("HH:mm")
                        ),
                        onClick = onEndTimeClick,
                        modifier = Modifier.weight(1f)
                    )
                }
                AmicumCard(
                    upperText = stringResource(R.string.type_of_awaiting),
                    lowerText = null,
                    onClick = onOtherFieldsClick
                )
                AmicumCard(
                    upperText = stringResource(R.string.add_reason_of_awaiting),
                    lowerText = null,
                    onClick = onOtherFieldsClick
                )
                AmicumCard(
                    upperText = stringResource(R.string.add_hardware),
                    lowerText = null,
                    onClick = onOtherFieldsClick
                )
                OutlinedTextField(
                    value = "",
                    onValueChange = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(128.dp),
                    placeholder = { Text(text = stringResource(R.string.comment)) }
                )
                Button(
                    onClick = onOtherFieldsClick,
                    Modifier.fillMaxWidth(),
                    shape = RectangleShape
                ) {
                    Text(text = stringResource(R.string.add_awaiting), Modifier.padding(mediumPadding))
                }
            }
        }
    )
}