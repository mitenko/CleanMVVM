package com.example.cleanmvvm.presentation.country_detail

import com.example.cleanmvvm.domain.model.Country

data class CountryDetailState(
    val isLoading: Boolean = false,
    val country: Country? = null,
    val error: String = "",
)
