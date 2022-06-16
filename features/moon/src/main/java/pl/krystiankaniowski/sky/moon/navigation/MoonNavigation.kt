package pl.krystiankaniowski.sky.moon.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import pl.krystiankaniowski.sky.moon.presentation.MoonScreen
import pl.krystiankaniowski.sky.navigation.Destination
import pl.krystiankaniowski.sky.navigation.Navigation

class MoonNavigation : Navigation {

    override val destination: Destination = Destination.Moon

    @Composable
    override fun Render(navHostController: NavHostController) {
        MoonScreen(navHostController)
    }
}