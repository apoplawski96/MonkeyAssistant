package ap.droidsoft.monkeyassistant.presentation.layouts

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp
import ap.droidsoft.monkeyassistant.presentation.util.DarkThemePreview
import monkeyassistant.composeapp.generated.resources.Res
import monkeyassistant.composeapp.generated.resources.exercise_24px
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RoutineIconLayout(painter: Painter) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(44.dp).background(
            color = MaterialTheme.colorScheme.surfaceVariant,
            shape = RoundedCornerShape(4.dp)
        ),
    ) {
        Icon(
            painter = painter,
            contentDescription = "Routine Icon",
            modifier = Modifier.size(24.dp),
            tint = MaterialTheme.colorScheme.onSurfaceVariant
        )
    }
}

@Preview
@Composable
private fun Preview() = DarkThemePreview {
    RoutineIconLayout(painterResource(Res.drawable.exercise_24px))
}