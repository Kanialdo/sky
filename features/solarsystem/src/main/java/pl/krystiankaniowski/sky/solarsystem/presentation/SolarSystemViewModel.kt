package pl.krystiankaniowski.sky.solarsystem.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.krystiankaniowski.sky.solarsystem.domain.CelestialBody
import pl.krystiankaniowski.sky.solarsystem.domain.GetSolarSystemDataUseCase
import javax.inject.Inject

@HiltViewModel
class SolarSystemViewModel @Inject constructor(
    getSolarSystemDataUseCase: GetSolarSystemDataUseCase,
) : ViewModel() {

    sealed class State {
        object Loading : State()
        data class Error(val message: String?) : State()
        data class Loaded(val data: List<CelestialBody>) : State()
    }

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            try {
                val data = getSolarSystemDataUseCase()
                _state.value = State.Loaded(
                    data = data,
                )
            } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
                _state.value = State.Error(e.message)
            }
        }
    }
}