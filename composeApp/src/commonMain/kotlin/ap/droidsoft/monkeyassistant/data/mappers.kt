package ap.droidsoft.monkeyassistant.data

import ap.droidsoft.monkeyassistant.cache.Routine
import ap.droidsoft.monkeyassistant.cache.Routine_completion
import ap.droidsoft.monkeyassistant.domain.model.RoutineCompletion
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.model.RoutineIcon
import ap.droidsoft.monkeyassistant.presentation.model.dbKey
import kotlinx.datetime.LocalDate

fun Routine.toDomainModel() = ap.droidsoft.monkeyassistant.domain.model.Routine(
    id = id.toInt(),
    name = name,
    description = description,
    routineInterval = RoutineInterval.valueOf(routine_interval),
    icon = RoutineIcon.valueOf(icon_key ?: RoutineIcon.Default.dbKey)
)

fun Routine_completion.toDomainModel() = RoutineCompletion(
    id = id.toInt(),
    routineId = routine_id.toInt(),
    completedOn = LocalDate.fromEpochDays(2),
)