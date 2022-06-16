package pl.krystiankaniowski.sky.solarsystem.domain

import javax.inject.Inject

class GetSolarSystemDataUseCase @Inject constructor() {

    operator fun invoke(): List<CelestialBody> {
        return listOf(
            CelestialBody("Sun", CelestialBodyType.Star),
            CelestialBody("Mercury", CelestialBodyType.Planet),
            CelestialBody("Venus", CelestialBodyType.Planet),
            CelestialBody("Earth", CelestialBodyType.Planet),
            CelestialBody("Mars", CelestialBodyType.Planet),
            CelestialBody("Jupiter", CelestialBodyType.Planet),
            CelestialBody("Saturn", CelestialBodyType.Planet),
            CelestialBody("Uranus", CelestialBodyType.Planet),
            CelestialBody("Neptune", CelestialBodyType.Planet),
        )
    }
}