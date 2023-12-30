package com.tusxapps.place

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOf

internal class PlacesRepositoryImpl(
    private val placesDataSource: PlacesDataSource
) : PlacesRepository {
    override suspend fun getPlaces(): Flow<List<Place>> = flowOf(
        placesDataSource.getPlaces()
    )

    override suspend fun getPlace(id: String): Flow<Place?> = flow {
        val place = placesDataSource.getPlaces().find { it.id == id }
        emit(place)
    }
}