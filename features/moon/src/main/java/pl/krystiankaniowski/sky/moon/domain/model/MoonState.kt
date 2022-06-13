package pl.krystiankaniowski.sky.moon.domain.model

data class MoonState(
    val rise: Long,
    val set: Long,
    val phase: Float,
)