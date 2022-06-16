@file:Suppress("MatchingDeclarationName")

package pl.krystiankaniowski.sky.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController

sealed class Destination(val route: String) {
    object Moon : Destination("/moon")
    object SolarSystem : Destination("/solarsystem")
    object About : Destination("/about")
}

fun NavHostController.navigate(destination: Destination) {
    navigate(destination.route)
}

interface Navigation {

    val destination: Destination

    @Composable
    fun Render(navHostController: NavHostController)
}