package com.tusxapps.idle.ui

import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.tusxapps.place.PlacesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

internal class IdleScreenModel(
    private val placesRepository: PlacesRepository
) : StateScreenModel<IdleScreenModel.State>(State()) {
    init {

    }

    fun onStartDateSelect(date: LocalDate) {
        mutableState.update {
            it.copy(startDateTime = it.startDateTime?.with(date) ?: date.atStartOfDay())
        }
    }

    fun onStartTimeSelect(time: LocalTime) {
        mutableState.update {
            it.copy(startDateTime = it.startDateTime?.with(time) ?: time.atDate(LocalDate.now()))
        }
    }

    fun onEndDateSelect(date: LocalDate) {
        mutableState.update {
            it.copy(endDateTime = it.endDateTime?.with(date) ?: date.atStartOfDay())
        }
    }

    fun onEndTimeSelect(time: LocalTime) {
        mutableState.update {
            it.copy(endDateTime = it.endDateTime?.with(time) ?: time.atDate(LocalDate.now()))
        }
    }

    fun loadPlace(placeId: String) {
        screenModelScope.launch {
            val place = placesRepository.getPlace(placeId).first()
            mutableState.update { it.copy(placeName = place?.name) }
        }
    }

    data class State(
        val placeName: String? = null,
        val startDateTime: LocalDateTime? = null,
        val endDateTime: LocalDateTime? = null
    )
}
