package ap.droidsoft.monkeyassistant.presentation.screens.routines

import ap.droidsoft.monkeyassistant.data.model.RoutineWithStatus
import ap.droidsoft.monkeyassistant.domain.model.Routine
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.model.RoutineUIModel

data class RoutinesScreenUIState(
    val testMessage: String? = null,
    val testRoutine: Routine? = null,
    val sections: List<RoutinesSection>? = null,
    val isLoading: Boolean = true,
)

data class RoutinesSection(
    val interval: RoutineInterval,
    val routines: List<RoutineWithStatus>,
)
