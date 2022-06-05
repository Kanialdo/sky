package pl.krystiankaniowski.sky.moon.infrastructure

import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import pl.krystiankaniowski.sky.moon.domain.model.Coords
import javax.inject.Inject

class OpenWeatherMapEndpoint @Inject constructor(private val client: HttpClient) {

    private val endpoint = "https://api.openweathermap.org/data/2.5"
    private val apiKey = "003da542b45fd794cd24797fa7a16d2e"

    suspend fun getWeatherByOneCallApi(location: Coords): OneCallApiResponse =
        client.get("$endpoint/onecall?lat=${location.latitude}&lon=${location.longitude}&appid=$apiKey")
            .body()

}

@Serializable
data class OneCallApiResponse(
    @SerialName("lat") val lat: Double,
    @SerialName("lon") val lon: Double,
    @SerialName("timezone") val timezone: String,
    @SerialName("timezone_offset") val timezoneOffset: Long,
    @SerialName("daily") val daily: List<Daily>? = null,
) {

    @Serializable
    data class Daily(
        @SerialName("dt") val dt: Long,
        @SerialName("sunrise") val sunrise: Long,
        @SerialName("sunset") val sunset: Long,
        @SerialName("moonrise") val moonrise: Long,
        @SerialName("moonset") val moonset: Long,
        @SerialName("moon_phase") val moonPhase: Double,
    )
}