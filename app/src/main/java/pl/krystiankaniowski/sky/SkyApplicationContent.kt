package pl.krystiankaniowski.sky

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.krystiankaniowski.sky.about.presentation.AboutScreen
import pl.krystiankaniowski.sky.compose.SkyTheme
import pl.krystiankaniowski.sky.moon.presentation.MoonScreen
import pl.krystiankaniowski.sky.navigation.Destination

@Composable
fun SkyApplicationContent() {

    val navController = rememberNavController()

    SkyTheme {
        NavHost(
            navController = navController,
            startDestination = Destination.Moon.route,
        ) {
            composable(Destination.Moon.route) { MoonScreen(navController) }
            composable(Destination.About.route) { AboutScreen(navController) }
        }
    }
}