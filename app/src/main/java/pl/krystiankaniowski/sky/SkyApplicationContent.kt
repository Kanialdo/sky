package pl.krystiankaniowski.sky

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Build
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import pl.krystiankaniowski.sky.about.presentation.AboutScreen
import pl.krystiankaniowski.sky.compose.SkyTheme
import pl.krystiankaniowski.sky.moon.presentation.MoonScreen
import pl.krystiankaniowski.sky.navigation.Destination
import pl.krystiankaniowski.sky.navigation.Navigation

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
                if (currentRoute in listOf(Destination.Moon.route)) {
                    SkyBottomBar()
                }
            }
        ) { padding ->
            NavHost(
                navController = navController,
                startDestination = Destination.Moon.route,
            ) {
                composable(Destination.Moon.route) { MoonScreen(navController) }
                composable(Destination.About.route) { AboutScreen(navController) }
            }
        }
    }
}

@Composable
fun SkyBottomBar() {
//    BottomAppBar {
//        IconButton(onClick = { /* doSomething() */ }) {
//            Icon(Icons.Default.Build, contentDescription = null)
//        }
//        IconButton(onClick = { /* doSomething() */ }) {
//            Icon(Icons.Default.AccountBox, contentDescription = null)
//        }
//    }
//
    var selectedItem by remember { mutableStateOf(0) }
    val items = listOf("Songs", "Artists", "Playlists")

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(item) },
                selected = selectedItem == index,
                onClick = { selectedItem = index }
            )
        }
    }
}