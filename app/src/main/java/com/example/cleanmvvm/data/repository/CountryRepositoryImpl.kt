package com.example.cleanmvvm.data.repository

import com.example.cleanmvvm.data.remote.CountryLayerApi
import com.example.cleanmvvm.data.remote.dto.CountryDto
import com.example.cleanmvvm.domain.repository.CountryRepository
import javax.inject.Inject

class CountryRepositoryImpl @Inject constructor(
    private val api: CountryLayerApi
) : CountryRepository{
    override suspend fun getCountries(): List<CountryDto> {
        return api.getCountries()
    }

    override suspend fun getCountryByCapital(capital: String): List<CountryDto> {
        return api.getCountryByCapital(capital)
    }

    override suspend fun getCountryByCode(code: String): CountryDto {
        return api.getCountryByCode(code)
    }
}