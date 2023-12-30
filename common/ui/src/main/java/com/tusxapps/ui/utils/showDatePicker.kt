package com.tusxapps.ui.utils

import android.app.Activity
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import java.time.LocalDate
import java.time.LocalTime


fun Activity.showDatePicker(
    onValueChange: (LocalDate) -> Unit = {}
) {
    val today = LocalDate.now()
    val dialog = DatePickerDialog(
        /* context = */ this,
        /* listener = */ { _, year, month, dayOfMonth ->
            onValueChange(LocalDate.of(year, month + 1, dayOfMonth))
        },
        /* year = */ today.year,
        /* month = */ today.monthValue - 1,
        /* dayOfMonth = */ today.dayOfMonth
    )
    dialog.show()
}

fun Activity.showTimePicker(
    onValueChange: (LocalTime) -> Unit
) {
    val today = LocalTime.now()
    val dialog = TimePickerDialog(
        /* context = */ this,
        /* listener = */ TimePickerDialog.OnTimeSetListener { _, hourOfDay, minute ->
            onValueChange(LocalTime.of(hourOfDay, minute))
        },
        /* hourOfDay = */ today.hour,
        /* minute = */ today.minute,
        /* is24HourView = */ true
    )
    dialog.show()
}