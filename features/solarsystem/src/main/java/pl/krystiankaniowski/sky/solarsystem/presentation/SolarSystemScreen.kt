package pl.krystiankaniowski.sky.solarsystem.presentation

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import pl.krystiankaniowski.sky.compose.SkyComponents
import pl.krystiankaniowski.sky.compose.SkyTheme
import pl.krystiankaniowski.sky.navigation.Destination
import pl.krystiankaniowski.sky.navigation.navigate
import pl.krystiankaniowski.sky.solarsystem.R
import pl.krystiankaniowski.sky.solarsystem.domain.CelestialBody
import pl.krystiankaniowski.sky.solarsystem.domain.CelestialBodyType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SolarSystemScreen(
    navHostController: NavHostController,
    viewModel: SolarSystemViewModel = hiltViewModel()
) {

    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(stringResource(R.string.solarsystem_title)) },
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
                is SolarSystemViewModel.State.Loaded -> SolarSystemLoaded(state)
                is SolarSystemViewModel.State.Error -> SkyComponents.Error(messageDetails = state.message)
                SolarSystemViewModel.State.Loading -> SkyComponents.Loading()
            }
        }
    }
}

@Composable
private fun SolarSystemLoaded(state: SolarSystemViewModel.State.Loaded) {
    LazyColumn {
        items(state.data.size) {
            CelestialBodyRow(state.data[it])
        }
    }
}

@Composable
private fun CelestialBodyRow(celestialBody: CelestialBody) {
    Row(modifier = Modifier.padding(16.dp)) {
        Text(text = celestialBody.name)
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = celestialBody.type.toString())
    }
}

@Preview(showBackground = true)
@Composable
private fun CelestialBodyRowPreview() {
    SkyTheme {
        CelestialBodyRow(
            CelestialBody(
                name = "Sun",
                type = CelestialBodyType.Star
            )
        )
    }
}