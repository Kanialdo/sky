@file:Suppress("MatchingDeclarationName")

package pl.krystiankaniowski.sky.navigation

import androidx.navigation.NavHostController

sealed class Destination(val route: String) {
    object Moon : Destination("/moon")
    object About : Destination("/about")
}

fun NavHostController.navigate(destination: Destination) {
    navigate(destination.route)
}