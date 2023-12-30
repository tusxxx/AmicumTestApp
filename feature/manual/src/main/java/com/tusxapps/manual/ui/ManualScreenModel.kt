package com.tusxapps.manual.ui

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.StateScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.tusxapps.place.Place
import com.tusxapps.place.PlacesRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

internal class ManualScreenModel(
    private val placesRepository: PlacesRepository
) : StateScreenModel<ManualScreenModel.State>(State()) {

    init {
        screenModelScope.launch {
            val places = placesRepository.getPlaces().first()
            mutableState.update { it.copy(places = places) }
        }
    }

    data class State(
        val places: List<Place> = emptyList()
    )
}