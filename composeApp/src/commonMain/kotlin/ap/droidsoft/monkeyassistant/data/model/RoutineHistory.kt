package ap.droidsoft.monkeyassistant.data.model

import ap.droidsoft.monkeyassistant.domain.model.Routine
import ap.droidsoft.monkeyassistant.domain.model.RoutineCompletion

data class RoutineHistory(
    val routine: Routine,
    val completionsHistory: List<RoutineCompletion>,
)
