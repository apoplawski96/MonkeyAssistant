package ap.droidsoft.monkeyassistant.presentation

import ap.droidsoft.monkeyassistant.domain.model.Routine

data class RoutinesScreenUIState(
    val testMessage: String? = null,
    val testRoutine: Routine? = null,
)
