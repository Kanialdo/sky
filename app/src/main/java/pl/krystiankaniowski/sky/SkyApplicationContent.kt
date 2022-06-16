package pl.krystiankaniowski.sky

import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pl.krystiankaniowski.sky.about.presentation.AboutScreen
import pl.krystiankaniowski.sky.compose.SkyTheme
import pl.krystiankaniowski.sky.moon.presentation.MoonScreen
import pl.krystiankaniowski.sky.navigation.Destination
import pl.krystiankaniowski.sky.solarsystem.presentation.SolarSystemScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkyApplicationContent() {
    SkyTheme {
        val navController = rememberNavController()

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        val currentRoute = currentDestination?.route

        Scaffold(
            bottomBar = {
                if (mainNavigation.any { it.destination.route == currentRoute }) {
                    SkyBottomBar(navController)
                }
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Destination.Moon.route,
            ) {
                composable(Destination.Moon.route) { MoonScreen(navController) }
                composable(Destination.SolarSystem.route) { SolarSystemScreen(navController) }
                composable(Destination.About.route) { AboutScreen(navController) }
            }
        }
    }
}

@Composable
fun SkyBottomBar(navController: NavController) {
    BottomAppBar {
        mainNavigation.forEach { item ->
            Button(onClick = { navController.navigate(item.destination.route) }) {
                Text(text = stringResource(item.name))
            }
        }
    }
}