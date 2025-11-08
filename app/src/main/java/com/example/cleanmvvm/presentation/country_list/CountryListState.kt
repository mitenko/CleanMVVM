package com.example.cleanmvvm.presentation.country_list

import com.example.cleanmvvm.domain.model.Country

data class CountryListState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = "",
)
