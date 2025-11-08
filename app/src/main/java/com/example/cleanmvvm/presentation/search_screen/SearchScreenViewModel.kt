package com.example.cleanmvvm.presentation.search_screen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cleanmvvm.common.Resource
import com.example.cleanmvvm.domain.use_case.get_country_by_capital.GetCountryByCapitalUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class SearchScreenViewModel @Inject constructor(
    private val getCountryByCapitalUseCase: GetCountryByCapitalUseCase
): ViewModel() {
    private val _state = mutableStateOf(SearchScreenState())
    val state : State<SearchScreenState> = _state

    init {

    }

    private fun getCountryByCapital(capital: String) {
        getCountryByCapitalUseCase(capital).onEach { result ->
            when(result) {
                is Resource.Loading -> {
                    _state.value = SearchScreenState(isLoading = true)
                }
                is Resource.Success -> {
                    _state.value = SearchScreenState(countries = result.data ?: emptyList())
                }
                is Resource.Error -> {
                    _state.value = SearchScreenState(error = result.message ?: "An unexpected error occurred")
                }
            }

        }.launchIn(viewModelScope)
    }
}