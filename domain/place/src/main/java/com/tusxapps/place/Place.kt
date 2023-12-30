package com.tusxapps.place

data class Place(
    val id: String,
    val name: String,
    val internalPlaces: List<Place>
)