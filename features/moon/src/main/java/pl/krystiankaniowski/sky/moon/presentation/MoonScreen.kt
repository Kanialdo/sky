package pl.krystiankaniowski.sky.moon.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import pl.krystiankaniowski.sky.compose.SkyComponents
import pl.krystiankaniowski.sky.compose.SkyTheme

@Composable
fun MoonScreen(viewModel: MoonViewModel = hiltViewModel()) {
    Box(modifier = Modifier.padding(16.dp)) {
        when (val state = viewModel.state.collectAsState().value) {
            is MoonViewModel.State.Loaded -> MoonScreenLoaded(state)
            MoonViewModel.State.Error -> SkyComponents.Error()
            MoonViewModel.State.Loading -> SkyComponents.Loading()
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