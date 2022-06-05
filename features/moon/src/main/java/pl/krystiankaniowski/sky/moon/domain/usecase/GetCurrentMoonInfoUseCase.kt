package pl.krystiankaniowski.sky.moon.domain.usecase

import kotlinx.coroutines.delay
import pl.krystiankaniowski.sky.moon.domain.model.MoonState
import javax.inject.Inject

class GetCurrentMoonInfoUseCase @Inject constructor() {

    suspend operator fun invoke(): MoonState {
        @Suppress("MagicNumber")
        delay(2000)
        return MoonState(
            rise = 0,
            set = 1000,
            phase = 1.0f,
        )
    }
}