package com.example.testapp.ui.details

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testapp.Resource
import com.example.testapp.domain.use_cases.GetCharacterDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val useCase: GetCharacterDetailsUseCase,
) : ViewModel() {
    private val _state: MutableStateFlow<DetailsState> = MutableStateFlow(DetailsState())
    val state: StateFlow<DetailsState> = _state.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent: SharedFlow<UiEvent> = _uiEvent.asSharedFlow()

    private val _colorPalette: MutableState<Map<String, String>> = mutableStateOf(mapOf())
    val colorPalette: State<Map<String, String>> = _colorPalette

    fun generatePaletteColors() {
        viewModelScope.launch {
            _uiEvent.emit(UiEvent.GenerateColorsPalette)
        }
    }

    fun setColorPalette(colors: Map<String, String>) {
        _colorPalette.value = colors
    }

    fun onGetCharacterEvent(id: Int) {
        useCase(id).onEach { result ->
            when (result) {
                is Resource.Loading -> {
                    _state.value = DetailsState(
                        isLoading = true
                    )
                }

                is Resource.Success -> {
                    _state.value = DetailsState(
                        characters = result.data
                    )
                }

                is Resource.Error -> {
                    _state.value = DetailsState(
                        error = result.message!!
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}

sealed class UiEvent {
    object GenerateColorsPalette : UiEvent()
}