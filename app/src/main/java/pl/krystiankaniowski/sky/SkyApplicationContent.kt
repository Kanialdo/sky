package pl.krystiankaniowski.sky

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import pl.krystiankaniowski.sky.moon.presentation.MoonScreen
import pl.krystiankaniowski.sky.ui.theme.SkyTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SkyApplicationContent() {
    SkyTheme {
        Scaffold(
            topBar = { SmallTopAppBar(title = { Text("Sky") }) }
        ) {
            Box(modifier = Modifier.padding(it)) {
                MoonScreen()
            }
        }
    }
}