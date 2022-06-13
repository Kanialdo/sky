package pl.krystiankaniowski.sky

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pl.krystiankaniowski.sky.compose.SkyTheme
import pl.krystiankaniowski.sky.moon.presentation.MoonScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkyApplicationContent() {

    val navController = rememberNavController()

    SkyTheme {
        NavHost(
            navController = navController,
            startDestination = "/",
        ) {
            composable("/") {
                Scaffold(
                    topBar = { SmallTopAppBar(title = { Text("Sky") }) }
                ) {
                    Box(modifier = Modifier.padding(it)) {
                        MoonScreen()
                    }
                }
            }
        }
    }
}