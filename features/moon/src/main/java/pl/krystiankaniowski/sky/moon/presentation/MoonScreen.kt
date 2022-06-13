package pl.krystiankaniowski.sky.moon.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import pl.krystiankaniowski.sky.compose.SkyComponents
import pl.krystiankaniowski.sky.compose.SkyTheme
import pl.krystiankaniowski.sky.navigation.Destination
import pl.krystiankaniowski.sky.navigation.navigate

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MoonScreen(navHostController: NavHostController, viewModel: MoonViewModel = hiltViewModel()) {

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text("Sky") },
                actions = {
                    IconButton(
                        onClick = { navHostController.navigate(Destination.About) }
                    ) {
                        Icon(
                            painter = rememberVectorPainter(Icons.Default.Info),
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .padding(16.dp)
        ) {
            when (val state = viewModel.state.collectAsState().value) {
                is MoonViewModel.State.Loaded -> MoonScreenLoaded(state)
                is MoonViewModel.State.Error -> SkyComponents.Error(messageDetails = state.message)
                MoonViewModel.State.Loading -> SkyComponents.Loading()
            }
        }
    }
}

@Composable
private fun MoonScreenLoaded(state: MoonViewModel.State.Loaded) {
    Column {
        Text("Moon 🌙")
        Text("moonrise ${state.rise}")
        Text("moonset ${state.set}")
        Text("moonPhase ${state.phase}")
    }
}

@Preview
@Composable
private fun MoonScreenLoadedPreview() {
    SkyTheme {
        MoonScreenLoaded(
            MoonViewModel.State.Loaded(
                rise = "20:00",
                set = "8:00",
                phase = 1f
            )
        )
    }
}