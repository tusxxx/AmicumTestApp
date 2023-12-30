package com.tusxapps.place

import java.util.Random


internal class PlacesDataSource {
    private val random = Random()
    private val places = listOf(
        Place("1", "Place 1", listOf(
            Place("11", "Place 1.1", listOf(
                Place("1313", "Place 1.1.1", listOf()),
                Place("1464", "Place 1.1.2", listOf(
                    Place("1225", "Place 1.1.2.1", listOf()),
                    Place("2221", "Place 1.1.2.2", listOf(
                        Place("15578", "Place 1.1.2.2.1", listOf()),
                        Place("1966", "Place 1.1.2.2.2", listOf(
                            Place("164555", "Place 1.1.2.2.2.1", listOf()),
                        )),
                    )),
                )),
            )),
            Place("188434", "Place 1.2", listOf()),
            Place("5341", "Place 1.3", listOf()),
        )),
        Place("1", "Place 2", listOf(
            Place("63471", "Place 2.1", listOf()),
            Place("7321", "Place 2.2", listOf()),
        )),
        Place("23511", "Place 3", listOf()),
        Place("73311", "Place 4", listOf(
            Place("2451", "Place 4.1", listOf(
                Place("1231", "Place 4.1.1", listOf()),
                Place("51231", "Place 4.1.2", listOf()),
                Place("6311", "Place 4.1.3", listOf()),
            )),
            Place("888751", "Place 4.2", listOf()),
        )),
    )
    // Представим, что лезем в сеть и получаем данные
    fun getPlaces(): List<Place> = places
}
