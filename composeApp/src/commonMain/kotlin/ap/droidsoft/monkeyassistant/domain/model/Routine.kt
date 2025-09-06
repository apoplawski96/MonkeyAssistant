package ap.droidsoft.monkeyassistant.domain.model

import ap.droidsoft.monkeyassistant.presentation.model.RoutineIcon

data class Routine(
    val id: Int,
    val name: String,
    val description: String? = null,
    val routineInterval: RoutineInterval = RoutineInterval.Daily,
    val icon: RoutineIcon = RoutineIcon.Default,
)
