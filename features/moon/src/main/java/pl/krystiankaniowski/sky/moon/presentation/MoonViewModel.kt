package pl.krystiankaniowski.sky.moon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MoonViewModel : ViewModel() {

    sealed class State {
        object Loading : State()
        object Error : State()
        data class Loaded(val moonrise: String, val moonset: String, val moonPhase: Float) : State()
    }

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            @Suppress("MagicNumber")
            delay(2000)
            _state.value = State.Loaded(
                moonrise = "20:00",
                moonset = "8:00",
                moonPhase = 1.0f,
            )
        }
    }
}