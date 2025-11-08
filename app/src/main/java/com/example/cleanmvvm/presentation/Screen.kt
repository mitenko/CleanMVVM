package com.example.cleanmvvm.presentation

sealed class Screen(val route: String) {
    object SearchScreen: Screen("search_screen")
    object DetailScreen: Screen("country_detail")
    object CountryListScreen: Screen("country_list")
}