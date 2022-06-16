package pl.krystiankaniowski.sky.solarsystem.domain

enum class CelestialBodyType {
    Star,
    Planet,
    Moon,
    Asteroid,
}

data class CelestialBody(val name: String, val type: CelestialBodyType)