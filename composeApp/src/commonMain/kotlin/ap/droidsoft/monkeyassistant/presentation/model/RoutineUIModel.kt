package ap.droidsoft.monkeyassistant.presentation.model

import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval

data class RoutineUIModel(
    val id: Int,
    val name: String,
    val routineInterval: RoutineInterval,
    val description: String? = null,
    val isCompleted: Boolean = false,
    val icon: RoutineIcon = RoutineIcon.Default,
)
