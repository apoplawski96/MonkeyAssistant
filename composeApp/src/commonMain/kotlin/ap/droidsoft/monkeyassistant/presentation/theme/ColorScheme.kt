package ap.droidsoft.monkeyassistant.presentation.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

// Light theme colors - modern and modest
private val LightPrimary = Color(0xFF2E7D32)        // Forest green
private val LightOnPrimary = Color(0xFFFFFFFF)      // White
private val LightPrimaryContainer = Color(0xFFA5D6A7) // Light green
private val LightOnPrimaryContainer = Color(0xFF1B5E20) // Dark green

private val LightSecondary = Color(0xFF455A64)       // Blue grey
private val LightOnSecondary = Color(0xFFFFFFFF)     // White
private val LightSecondaryContainer = Color(0xFFCFD8DC) // Light blue grey
private val LightOnSecondaryContainer = Color(0xFF263238) // Dark blue grey

private val LightTertiary = Color(0xFF6A4C93)        // Muted purple
private val LightOnTertiary = Color(0xFFFFFFFF)      // White
private val LightTertiaryContainer = Color(0xFFE1BEE7) // Light purple
private val LightOnTertiaryContainer = Color(0xFF4A148C) // Dark purple

private val LightError = Color(0xFFD32F2F)           // Red
private val LightOnError = Color(0xFFFFFFFF)         // White
private val LightErrorContainer = Color(0xFFFFCDD2)  // Light red
private val LightOnErrorContainer = Color(0xFFB71C1C) // Dark red

private val LightBackground = Color(0xFFFAFAFA)      // Very light grey
private val LightOnBackground = Color(0xFF1C1B1F)    // Almost black
private val LightSurface = Color(0xFFFFFFFF)         // White
private val LightOnSurface = Color(0xFF1C1B1F)       // Almost black
private val LightSurfaceVariant = Color(0xFFF5F5F5)  // Light grey
private val LightOnSurfaceVariant = Color(0xFF49454F) // Medium grey
private val LightOutline = Color(0xFF79747E)         // Grey
private val LightInverseSurface = Color(0xFF313033)  // Dark grey
private val LightInverseOnSurface = Color(0xFFF4EFF4) // Light grey

// Dark theme colors - modern and modest
private val DarkPrimary = Color(0xFF66BB6A)          // Light green
private val DarkOnPrimary = Color(0xFF1B5E20)        // Dark green
private val DarkPrimaryContainer = Color(0xFF2E7D32) // Forest green
private val DarkOnPrimaryContainer = Color(0xFFA5D6A7) // Light green

private val DarkSecondary = Color(0xFF90A4AE)        // Light blue grey
private val DarkOnSecondary = Color(0xFF263238)      // Dark blue grey
private val DarkSecondaryContainer = Color(0xFF37474F) // Medium blue grey
private val DarkOnSecondaryContainer = Color(0xFFCFD8DC) // Light blue grey

private val DarkTertiary = Color(0xFFBA68C8)         // Light purple
private val DarkOnTertiary = Color(0xFF4A148C)       // Dark purple
private val DarkTertiaryContainer = Color(0xFF6A4C93) // Muted purple
private val DarkOnTertiaryContainer = Color(0xFFE1BEE7) // Light purple

private val DarkError = Color(0xFFEF5350)            // Light red
private val DarkOnError = Color(0xFFB71C1C)          // Dark red
private val DarkErrorContainer = Color(0xFFD32F2F)   // Red
private val DarkOnErrorContainer = Color(0xFFFFCDD2) // Light red

private val DarkBackground = Color(0xFF121212)       // Very dark grey
private val DarkOnBackground = Color(0xFFE6E1E5)     // Light grey
private val DarkSurface = Color(0xFF1E1E1E)          // Dark grey
private val DarkOnSurface = Color(0xFFE6E1E5)        // Light grey
private val DarkSurfaceVariant = Color(0xFF2C2C2C)   // Medium dark grey
private val DarkOnSurfaceVariant = Color(0xFFCAC4D0) // Light grey
private val DarkOutline = Color(0xFF938F99)          // Medium grey
private val DarkInverseSurface = Color(0xFFE6E1E5)   // Light grey
private val DarkInverseOnSurface = Color(0xFF1C1B1F) // Almost black

val MonkeyAssistantLightColorScheme = lightColorScheme(
    primary = LightPrimary,
    onPrimary = LightOnPrimary,
    primaryContainer = LightPrimaryContainer,
    onPrimaryContainer = LightOnPrimaryContainer,
    secondary = LightSecondary,
    onSecondary = LightOnSecondary,
    secondaryContainer = LightSecondaryContainer,
    onSecondaryContainer = LightOnSecondaryContainer,
    tertiary = LightTertiary,
    onTertiary = LightOnTertiary,
    tertiaryContainer = LightTertiaryContainer,
    onTertiaryContainer = LightOnTertiaryContainer,
    error = LightError,
    onError = LightOnError,
    errorContainer = LightErrorContainer,
    onErrorContainer = LightOnErrorContainer,
    background = LightBackground,
    onBackground = LightOnBackground,
    surface = LightSurface,
    onSurface = LightOnSurface,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = LightOnSurfaceVariant,
    outline = LightOutline,
    inverseSurface = LightInverseSurface,
    inverseOnSurface = LightInverseOnSurface,
)

val MonkeyAssistantDarkColorScheme = darkColorScheme(
    primary = DarkPrimary,
    onPrimary = DarkOnPrimary,
    primaryContainer = DarkPrimaryContainer,
    onPrimaryContainer = DarkOnPrimaryContainer,
    secondary = DarkSecondary,
    onSecondary = DarkOnSecondary,
    secondaryContainer = DarkSecondaryContainer,
    onSecondaryContainer = DarkOnSecondaryContainer,
    tertiary = DarkTertiary,
    onTertiary = DarkOnTertiary,
    tertiaryContainer = DarkTertiaryContainer,
    onTertiaryContainer = DarkOnTertiaryContainer,
    error = DarkError,
    onError = DarkOnError,
    errorContainer = DarkErrorContainer,
    onErrorContainer = DarkOnErrorContainer,
    background = DarkBackground,
    onBackground = DarkOnBackground,
    surface = DarkSurface,
    onSurface = DarkOnSurface,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkOnSurfaceVariant,
    outline = DarkOutline,
    inverseSurface = DarkInverseSurface,
    inverseOnSurface = DarkInverseOnSurface,
)

@Composable
fun getColorScheme(darkTheme: Boolean = isSystemInDarkTheme()): ColorScheme {
    return if (darkTheme) {
        MonkeyAssistantDarkColorScheme
    } else {
        MonkeyAssistantLightColorScheme
    }
}