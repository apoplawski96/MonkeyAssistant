package ap.droidsoft.monkeyassistant.data

import ap.droidsoft.monkeyassistant.cache.Routine
import ap.droidsoft.monkeyassistant.cache.Routine_completion
import ap.droidsoft.monkeyassistant.domain.model.RoutineCompletion
import kotlinx.datetime.LocalDate

fun Routine.toDomainModel() = ap.droidsoft.monkeyassistant.domain.model.Routine(
    id = id.toInt(),
    name = name,
    description = description,
)

fun Routine_completion.toDomainModel() = RoutineCompletion(
    id = id.toInt(),
    routineId = routine_id.toInt(),
    completedOn = LocalDate.parse(completed_on),
)

fun ap.droidsoft.monkeyassistant.domain.model.Routine.toDbModel() = Routine(
    id = id.toLong(),
    name = name,
    description = description,
    routine_interval = routineInterval.name,
)