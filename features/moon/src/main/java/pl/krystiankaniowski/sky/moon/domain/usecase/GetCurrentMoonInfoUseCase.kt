package pl.krystiankaniowski.sky.moon.domain.usecase

import pl.krystiankaniowski.sky.moon.domain.model.Cords
import pl.krystiankaniowski.sky.moon.domain.model.MoonState
import pl.krystiankaniowski.sky.moon.infrastructure.OpenWeatherMapEndpoint
import javax.inject.Inject

class GetCurrentMoonInfoUseCase @Inject constructor(
    private val endpoint: OpenWeatherMapEndpoint,
) {

    private val wawCords = Cords(latitude = 52.23, longitude = 20.77)

    suspend operator fun invoke(): MoonState {
        val data = endpoint.getWeatherByOneCallApi(wawCords)
        val today = data.daily?.first() ?: error("No data")
        return MoonState(
            rise = today.moonrise,
            set = today.moonset,
            phase = today.moonPhase.toFloat(),
        )
    }
}