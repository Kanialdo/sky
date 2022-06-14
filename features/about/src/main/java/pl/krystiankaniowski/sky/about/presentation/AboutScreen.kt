package pl.krystiankaniowski.sky.about.presentation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import pl.krystiankaniowski.sky.about.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navHostController: NavHostController) {
    Scaffold(
        topBar = {
            SmallTopAppBar(
                title = { Text(stringResource(R.string.about_title)) },
                navigationIcon = {
                    IconButton(onClick = navHostController::popBackStack) {
                        Icon(
                            painter = rememberVectorPainter(image = Icons.Default.ArrowBack),
                            contentDescription = stringResource(R.string.back)
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
            Text(stringResource(R.string.about_description))
        }
    }
}