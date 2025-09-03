package ap.droidsoft.monkeyassistant.domain.model

data class Routine(
    val id: Int,
    val name: String,
    val description: String,
    val routineInterval: RoutineInterval = RoutineInterval.Daily,
)
