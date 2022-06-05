package pl.krystiankaniowski.sky.moon.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Coords(
    @SerialName("lat") val latitude: Double,
    @SerialName("lon") val longitude: Double,
)