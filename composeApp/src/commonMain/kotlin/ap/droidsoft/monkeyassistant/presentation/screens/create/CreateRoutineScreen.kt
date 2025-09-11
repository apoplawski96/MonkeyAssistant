package ap.droidsoft.monkeyassistant.presentation.screens.create

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.layouts.RoutineIconLayout
import ap.droidsoft.monkeyassistant.presentation.layouts.VerticalSpacer
import ap.droidsoft.monkeyassistant.presentation.model.RoutineIcon
import monkeyassistant.composeapp.generated.resources.Res
import monkeyassistant.composeapp.generated.resources.allDrawableResources
import ap.droidsoft.monkeyassistant.presentation.model.resourceId
import monkeyassistant.composeapp.generated.resources.arrow_back_24px
import monkeyassistant.composeapp.generated.resources.menu
import org.jetbrains.compose.resources.painterResource
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun CreateRoutineScreen(
    navController: NavController,
    viewModel: CreateRoutineViewModel = koinViewModel(),
) {
    val uiState by viewModel.inputs.collectAsStateWithLifecycle()
    val isFormValid by viewModel.isFormValid.collectAsStateWithLifecycle()
    val creatingFinished by viewModel.creatingFinished.collectAsStateWithLifecycle()

    // Navigate back when creation is finished
    if (creatingFinished) {
        LaunchedEffect(Unit) {
            navController.popBackStack()
        }
    }

    CreateRoutineLayout(
        uiState = uiState,
        isFormValid = isFormValid,
        onNameChanged = viewModel::updateName,
        onDescriptionChanged = viewModel::updateDescription,
        onIntervalChanged = viewModel::updateInterval,
        onIconChanged = viewModel::updateIcon,
        onCreateClicked = viewModel::createRoutine,
        navigateBack = { navController.popBackStack() }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreateRoutineLayout(
    uiState: CreateRoutineScreenUIState,
    isFormValid: Boolean,
    onNameChanged: (String) -> Unit,
    onDescriptionChanged: (String) -> Unit,
    onIntervalChanged: (RoutineInterval) -> Unit,
    onIconChanged: (RoutineIcon) -> Unit,
    onCreateClicked: () -> Unit,
    navigateBack: () -> Unit = {},
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Create routine", style = MaterialTheme.typography.headlineSmall)
                },
                navigationIcon = {
                    IconButton(onClick = navigateBack) {
                        Icon(
                            painter = painterResource(Res.drawable.arrow_back_24px),
                            "Back navigation",
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Name Input
            OutlinedTextField(
                value = uiState.nameInput,
                onValueChange = onNameChanged,
                label = { Text("Name") },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true
            )

            // Description Input
            OutlinedTextField(
                value = uiState.descriptionInput,
                onValueChange = onDescriptionChanged,
                label = { Text("Description (Optional)") },
                modifier = Modifier.fillMaxWidth(),
                maxLines = 3
            )

            VerticalSpacer(8.dp)

            // Interval Picker
            Text("Interval", style = MaterialTheme.typography.labelLarge)
            IntervalDropdown(
                selectedInterval = uiState.intervalInput,
                onIntervalSelected = onIntervalChanged
            )

            VerticalSpacer(8.dp)

            // Icon Picker
            Text("Icon", style = MaterialTheme.typography.labelLarge)
            IconPicker(
                selectedIcon = uiState.iconInput,
                onIconSelected = onIconChanged
            )

            VerticalSpacer(24.dp)

            // Create Button
            Button(
                onClick = onCreateClicked,
                enabled = isFormValid,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Create Routine")
            }
        }
    }
}

@Composable
private fun IntervalDropdown(
    selectedInterval: RoutineInterval,
    onIntervalSelected: (RoutineInterval) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }

    Column {
        OutlinedTextField(
            value = selectedInterval.name,
            onValueChange = { },
            readOnly = true,
            label = { Text("Select Interval") },
            modifier = Modifier
                .fillMaxWidth()
                .clickable { expanded = true },
            trailingIcon = { /* Add dropdown arrow icon if desired */ }
        )

        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            RoutineInterval.entries.forEach { interval ->
                DropdownMenuItem(
                    text = { Text(interval.name) },
                    onClick = {
                        onIntervalSelected(interval)
                        expanded = false
                    }
                )
            }
        }
    }
}

@Composable
private fun IconPicker(
    selectedIcon: RoutineIcon,
    onIconSelected: (RoutineIcon) -> Unit
) {
    val gridState = rememberLazyGridState()
    LazyVerticalGrid(
        columns = GridCells.Fixed(4),
        state = gridState,
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(RoutineIcon.entries) { icon ->
            val isSelected = icon == selectedIcon
            RoutineIconLayout(
                painter = painterResource(Res.allDrawableResources[icon.resourceId]!!),
                isSelected = isSelected,
                onClick = { onIconSelected(icon) }
            )
        }
    }
}