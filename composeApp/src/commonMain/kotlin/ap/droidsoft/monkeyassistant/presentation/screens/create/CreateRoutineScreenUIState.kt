package ap.droidsoft.monkeyassistant.presentation.screens.create

import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.model.RoutineIcon

data class CreateRoutineScreenUIState(
    val nameInput: String = "",
    val descriptionInput: String = "",
    val intervalInput: RoutineInterval = RoutineInterval.Daily,
    val iconInput: RoutineIcon = RoutineIcon.Default,
)
