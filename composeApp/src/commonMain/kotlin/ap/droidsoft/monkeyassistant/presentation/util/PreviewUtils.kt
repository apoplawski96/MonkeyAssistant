package ap.droidsoft.monkeyassistant.presentation.util

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable

@Composable
fun DarkThemePreview(content: @Composable () -> Unit) {
    MaterialTheme(darkColorScheme()) {
        content()
    }
}