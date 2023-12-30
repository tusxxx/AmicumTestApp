package com.tusxapps.place.di

import com.tusxapps.place.PlacesDataSource
import com.tusxapps.place.PlacesRepository
import com.tusxapps.place.PlacesRepositoryImpl
import org.koin.dsl.module

val placesModule = module {
    factory { PlacesDataSource() }
    factory<PlacesRepository> { PlacesRepositoryImpl(get()) }
}