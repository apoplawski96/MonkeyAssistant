package ap.droidsoft.monkeyassistant.presentation.screens.routines

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ap.droidsoft.monkeyassistant.Routes
import ap.droidsoft.monkeyassistant.data.model.RoutineWithStatus
import ap.droidsoft.monkeyassistant.domain.model.Routine
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.layouts.HorizontalSpacer
import ap.droidsoft.monkeyassistant.presentation.layouts.RoutineIconLayout
import ap.droidsoft.monkeyassistant.presentation.layouts.VerticalSpacer
import ap.droidsoft.monkeyassistant.presentation.model.resourceId
import ap.droidsoft.monkeyassistant.presentation.util.DarkThemePreview
import monkeyassistant.composeapp.generated.resources.Res
import monkeyassistant.composeapp.generated.resources.allDrawableResources
import monkeyassistant.composeapp.generated.resources.default_24px
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RoutinesScreen(
    navController: NavController,
    viewModel: RoutinesScreenViewModel = koinViewModel(),
) {
    val routinesSections by viewModel.routinesSections.collectAsStateWithLifecycle()

    RoutinesLayout(
        onCheckboxClick = viewModel::toggleRoutineCompleted,
        routinesSections = routinesSections,
        navigateToCreateRoutine = {
            navController.navigate(Routes.CreateRoutine)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun RoutinesLayout(
    routinesSections: List<RoutinesSection>,
    onCheckboxClick: (RoutineWithStatus) -> Unit,
    navigateToCreateRoutine: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Routines", style = MaterialTheme.typography.headlineSmall)
                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = navigateToCreateRoutine, shape = CircleShape) {
                Icon(painter = painterResource(Res.drawable.default_24px), "Add routine")
            }
        }
    ) { innerPadding ->
        Column(Modifier.fillMaxSize().padding(16.dp).padding(innerPadding)) {
            if (routinesSections.isEmpty()) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("No routines created yet.", style = MaterialTheme.typography.bodyMedium)
                }
            } else {
                routinesSections.forEach { section ->
                    RoutinesSection(section, onCheckboxClick)
                }
            }
        }
    }
}

@Composable
private fun RoutinesSection(
    section: RoutinesSection,
    onCheckboxClick: (RoutineWithStatus) -> Unit,
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
    model: RoutineWithStatus,
    onCheckboxClick: (RoutineWithStatus) -> Unit,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            RoutineIconLayout(painter = painterResource(Res.allDrawableResources[model.routine.icon.resourceId]!!))
            HorizontalSpacer(8.dp)
            Column {
                Text(model.routine.name, style = MaterialTheme.typography.titleMedium)
                Text("11:00 AM", style = MaterialTheme.typography.bodyMedium.copy(color = Color.White.copy(alpha = 0.5f)))
            }
        }
        Checkbox(model.hasCompleted, onCheckedChange = { onCheckboxClick.invoke(model) })
    }
}

private val previewSections = listOf(
    RoutinesSection(
        interval = RoutineInterval.Daily,
        routines = emptyList()
    )
)

//private val previewState = RoutinesScreenUIState(
//    sections = listOf(
//        RoutinesSection(
//            interval = RoutineInterval.Daily,
//            routines = listOf(
//                RoutineWithStatus(routine = Routine(1, "Supplementation"), hasCompleted = true),
//                RoutineWithStatus(routine = Routine(2, "Meditation"), hasCompleted = true),
//                RoutineWithStatus(routine = Routine(3, "Workout"), hasCompleted = true),
//            )
//        )
//    )
//)

@Preview
@Composable
private fun Preview() = DarkThemePreview {
    RoutinesLayout(onCheckboxClick = {}, navigateToCreateRoutine = {}, routinesSections = previewSections)
}