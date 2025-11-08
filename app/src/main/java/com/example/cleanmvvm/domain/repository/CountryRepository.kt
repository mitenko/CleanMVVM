package com.example.cleanmvvm.domain.repository

import com.example.cleanmvvm.data.remote.dto.CountryDto

interface CountryRepository {
    suspend fun getCountries(): List<CountryDto>
    suspend fun getCountryByCapital(capital: String): List<CountryDto>

    suspend fun getCountryByCode(code: String): CountryDto
}