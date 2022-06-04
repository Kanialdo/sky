package pl.krystiankaniowski.sky.moon.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MoonScreen(viewModel: MoonViewModel = MoonViewModel()) {
    Box(modifier = Modifier.padding(16.dp)) {
        when (val state = viewModel.state.collectAsState().value) {
            is MoonViewModel.State.Data -> MoonScreenLoaded(state)
            MoonViewModel.State.Error -> Text("Error")
            MoonViewModel.State.Loading -> Text("Loading")
        }
    }
}

@Composable
private fun MoonScreenLoaded(state: MoonViewModel.State.Data) {
    Column {
        Text("Moon 🌙")
        Text("moonrise ${state.moonrise}")
        Text("moonset ${state.moonset}")
        Text("moonPhase ${state.moonPhase}")
    }
}