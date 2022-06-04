package pl.krystiankaniowski.sky.compose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

object SkyComponents {

    @Composable
    fun Loading(
        modifier: Modifier = Modifier,
        message: String = stringResource(R.string.commons_loading),
        additionalMessage: String? = null
    ) {
        StateView(
            modifier = modifier,
            headerContent = { CircularProgressIndicator() },
            message = message,
            additionalMessage = additionalMessage,
        )
    }

    @Composable
    fun Empty(
        modifier: Modifier = Modifier,
        message: String = stringResource(R.string.commons_no_data),
        additionalMessage: String? = null,
    ) {
        StateView(
            modifier = modifier,
            headerContent = {
                Image(
                    modifier = Modifier.size(64.dp),
                    imageVector = Icons.Default.Clear,
                    contentDescription = message,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.primary),
                )
            },
            message = message,
            additionalMessage = additionalMessage
        )
    }

    @Composable
    fun Error(
        modifier: Modifier = Modifier,
        message: String = stringResource(R.string.commons_error),
        messageDetails: String? = null
    ) {
        StateView(
            modifier = modifier,
            headerContent = {
                Image(
                    imageVector = Icons.Default.Warning,
                    contentDescription = message,
                    colorFilter = ColorFilter.tint(MaterialTheme.colorScheme.error),
                )
            },
            message = message,
            additionalMessage = messageDetails,
        )
    }

    @Composable
    private fun StateView(
        modifier: Modifier = Modifier,
        headerContent: (@Composable () -> Unit)? = null,
        message: String,
        additionalMessage: String? = null,
    ) {
        StateView(
            modifier = modifier,
            header = headerContent?.let { headerContent },
            content = { Text(message) },
            additionalContent = additionalMessage?.let { { Text(additionalMessage) } },
        )
    }

    @Composable
    private fun StateView(
        modifier: Modifier = Modifier,
        header: (@Composable () -> Unit)? = null,
        content: @Composable () -> Unit = {},
        additionalContent: @Composable (() -> Unit)? = null,
    ) {
        Column(
            modifier = modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            header?.let {
                header()
                Spacer(modifier = Modifier.height(16.dp))
            }
            ProvideTextStyle(value = MaterialTheme.typography.bodyMedium) {
                content()
            }
            additionalContent?.let { content ->
                Spacer(modifier = Modifier.height(8.dp))
                ProvideTextStyle(value = MaterialTheme.typography.bodySmall) {
                    content()
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun LoadingViewPreview() {
    Box(modifier = Modifier.size(250.dp)) {
        SkyComponents.Loading()
    }
}

@Preview(showBackground = true)
@Composable
private fun EmptyViewPreview() {
    Box(modifier = Modifier.size(250.dp)) {
        SkyComponents.Empty(message = "No data", additionalMessage = "More details here")
    }
}

@Preview(showBackground = true)
@Composable
private fun ErrorViewPreview() {
    Box(modifier = Modifier.size(250.dp)) {
        SkyComponents.Error()
    }
}