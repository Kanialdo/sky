@file:Suppress("MatchingDeclarationName")

package pl.krystiankaniowski.sky

import androidx.annotation.StringRes
import pl.krystiankaniowski.sky.navigation.Destination

data class MainRoute(val destination: Destination, @StringRes val name: Int)

val mainNavigation = listOf(
    MainRoute(Destination.Moon, pl.krystiankaniowski.sky.moon.R.string.moon_title),
    MainRoute(Destination.SolarSystem, pl.krystiankaniowski.sky.solarsystem.R.string.solarsystem_title),
)