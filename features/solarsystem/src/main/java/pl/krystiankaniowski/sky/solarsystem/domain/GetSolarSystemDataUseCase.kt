package pl.krystiankaniowski.sky.solarsystem.domain

class GetSolarSystemDataUseCase {

    suspend operator fun invoke(): List<CelestialBody> {
        return listOf(
            CelestialBody("Sun", CelestialBodyType.Star),
            CelestialBody("Earth", CelestialBodyType.Planet)
        )
    }
}