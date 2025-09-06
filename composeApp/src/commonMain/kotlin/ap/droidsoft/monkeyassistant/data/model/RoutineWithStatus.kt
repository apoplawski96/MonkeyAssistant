package ap.droidsoft.monkeyassistant.data.model

import ap.droidsoft.monkeyassistant.domain.model.Routine

data class RoutineWithStatus(
    val routine: Routine,
    val hasCompleted: Boolean,
)
