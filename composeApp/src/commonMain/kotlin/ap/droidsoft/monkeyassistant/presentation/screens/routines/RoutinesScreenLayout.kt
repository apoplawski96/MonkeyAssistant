package ap.droidsoft.monkeyassistant.presentation.screens.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.layouts.HorizontalSpacer
import ap.droidsoft.monkeyassistant.presentation.layouts.RoutineIconLayout
import ap.droidsoft.monkeyassistant.presentation.layouts.VerticalSpacer
import ap.droidsoft.monkeyassistant.presentation.model.RoutineUIModel
import ap.droidsoft.monkeyassistant.presentation.model.resourceId
import ap.droidsoft.monkeyassistant.presentation.util.DarkThemePreview
import monkeyassistant.composeapp.generated.resources.Res
import monkeyassistant.composeapp.generated.resources.allDrawableResources
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun RoutinesScreen() {
    RoutinesLayout(
        previewState,
        onCheckboxClick = {}
    )
}

@Composable
private fun RoutinesLayout(
    state: RoutinesScreenUIState,
    onCheckboxClick: (Boolean) -> Unit,
) {
    Scaffold {
        Column(Modifier.fillMaxSize().padding(16.dp)) {
            // test
//            RoutineIcon.entries.forEach {
//                val resource = Res.allDrawableResources[it.resourceId]
//                resource?.let { res ->
//                    Image(painterResource(res), "test icon")
//                }
//            }

            state.sections?.forEach { section ->
                RoutinesSection(section, onCheckboxClick)
            }
        }
    }
}

@Composable
private fun RoutinesSection(
    section: RoutinesSection,
    onCheckboxClick: (Boolean) -> Unit,
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(section.interval.name, style = MaterialTheme.typography.headlineMedium)
        VerticalSpacer(16.dp)
        section.routines.forEach { routine ->
            RoutineCell(routine, onCheckboxClick)
            VerticalSpacer(8.dp)
        }
    }
}

@Composable
private fun RoutineCell(
    model: RoutineUIModel,
    onCheckboxClick: (Boolean) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RoutineIconLayout(painter = painterResource(Res.allDrawableResources[model.icon.resourceId]!!))
            HorizontalSpacer(8.dp)
            Column {
                Text(model.name, style = MaterialTheme.typography.titleMedium)
                Text("11:00 AM", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White.copy(alpha = 0.5f)))
            }
        }
        Checkbox(model.isCompleted, onCheckedChange = onCheckboxClick)
    }
}

private val previewState = RoutinesScreenUIState(
    sections = listOf(
        RoutinesSection(
            interval = RoutineInterval.Daily,
            routines = listOf(
                RoutineUIModel(1, "Workout", RoutineInterval.Daily),
                RoutineUIModel(2, "Meditation", RoutineInterval.Daily),
                RoutineUIModel(3, "Workout", RoutineInterval.Daily),
            )
        )
    )
)

@Preview
@Composable
private fun Preview() = DarkThemePreview {
    RoutinesLayout(state = previewState, onCheckboxClick = {})
}