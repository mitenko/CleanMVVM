package com.example.cleanmvvm.domain.model

import com.example.cleanmvvm.data.remote.dto.CountryDto

data class Country(
    val alpha2Code: String,
    val alpha3Code: String,
    val altSpellings: List<String>,
    val callingCodes: List<String>,
    val capital: String,
    val name: String,
    val region: String,
    val topLevelDomain: List<String>
)

fun CountryDto.toCountry(): Country {
    return Country(
        alpha2Code = alpha2Code,
        alpha3Code = alpha3Code,
        altSpellings = altSpellings,
        callingCodes = callingCodes,
        capital = capital,
        name = name,
        region = region,
        topLevelDomain = topLevelDomain
    )
}