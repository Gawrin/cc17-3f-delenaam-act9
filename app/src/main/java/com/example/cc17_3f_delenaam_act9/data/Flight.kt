package com.example.cc17_3f_delenaam_act9.data

data class Flight(
    val departureAirport: Airport,
    val destinationAirport: Airport,
    var isFavorite: Boolean = false
)