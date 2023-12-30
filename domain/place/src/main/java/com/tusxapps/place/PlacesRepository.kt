package com.tusxapps.place

import kotlinx.coroutines.flow.Flow

interface PlacesRepository {
    suspend fun getPlaces(): Flow<List<Place>>
    suspend fun getPlace(id: String): Flow<Place?>
}