package ap.droidsoft.monkeyassistant.domain.model

import kotlinx.datetime.LocalDate

data class RoutineCompletion(
    val id: Int,
    val routineId: Int,
    val completedOn: LocalDate,
)
