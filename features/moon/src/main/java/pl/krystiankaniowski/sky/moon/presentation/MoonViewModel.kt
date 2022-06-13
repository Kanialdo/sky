package pl.krystiankaniowski.sky.moon.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import pl.krystiankaniowski.sky.moon.domain.usecase.GetCurrentMoonInfoUseCase
import javax.inject.Inject

@HiltViewModel
class MoonViewModel @Inject constructor(
    getCurrentMoonInfoUseCase: GetCurrentMoonInfoUseCase,
) : ViewModel() {

    sealed class State {
        object Loading : State()
        data class Error(val message: String?) : State()
        data class Loaded(val rise: String, val set: String, val phase: Float) : State()
    }

    private val _state: MutableStateFlow<State> = MutableStateFlow(State.Loading)
    val state: StateFlow<State> = _state

    init {
        viewModelScope.launch {
            try {
                val currentMoonInfo = getCurrentMoonInfoUseCase()
                _state.value = State.Loaded(
                    rise = currentMoonInfo.rise.toString(),
                    set = currentMoonInfo.set.toString(),
                    phase = currentMoonInfo.phase,
                )
            } catch (@Suppress("TooGenericExceptionCaught") e: Exception) {
                _state.value = State.Error(e.message)
            }
        }
    }
}