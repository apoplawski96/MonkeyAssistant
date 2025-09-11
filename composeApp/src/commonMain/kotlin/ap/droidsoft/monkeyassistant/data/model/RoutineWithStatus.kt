package ap.droidsoft.monkeyassistant.data.model

import ap.droidsoft.monkeyassistant.domain.model.Routine
import ap.droidsoft.monkeyassistant.domain.model.RoutineCompletion

data class RoutineWithStatus(
    val routine: Routine,
    val routineCompletion: RoutineCompletion? = null,
) {
    val hasCompleted: Boolean get() = routineCompletion != null
}
