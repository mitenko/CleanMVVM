package com.example.cleanmvvm.presentation.search_screen

import com.example.cleanmvvm.domain.model.Country

data class SearchScreenState(
    val isLoading: Boolean = false,
    val countries: List<Country> = emptyList(),
    val error: String = "",
)
