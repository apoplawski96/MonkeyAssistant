package ap.droidsoft.monkeyassistant.data.repository

import ap.droidsoft.monkeyassistant.data.cache.CompletionDatabase
import ap.droidsoft.monkeyassistant.data.cache.RoutinesDatabase
import ap.droidsoft.monkeyassistant.data.model.RoutineHistory
import ap.droidsoft.monkeyassistant.data.model.RoutineWithStatus
import ap.droidsoft.monkeyassistant.data.toDomainModel
import ap.droidsoft.monkeyassistant.domain.model.RoutineCompletion
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.model.RoutineIcon
import ap.droidsoft.monkeyassistant.presentation.model.dbKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class RoutinesRepository(
    private val routinesDb: RoutinesDatabase,
    private val completionsDb: CompletionDatabase,
    private val dateTimeRepository: DateTimeRepository,
) {

    fun getRoutinesWithCompletionStatus() : Flow<List<RoutineWithStatus>> = combine(
        routinesDb.getAllRoutines(),
        completionsDb.getAllCompletions(),
    ) { routines, completions ->
        routines.map { routine ->
            val completion = completions.find { completion ->
                completion.routine_id == routine.id
//                        && completion.completed_on == "TODAY"
            }
            RoutineWithStatus(routine.toDomainModel(), completion?.toDomainModel())
        }
    }

    fun getRoutinesHistory() : Flow<List<RoutineHistory>> = combine(
        routinesDb.getAllRoutines(),
        completionsDb.getAllCompletions(),
    ) { routines, completions ->
        routines.map { routine ->
            RoutineHistory(
                routine.toDomainModel(),
                completionsHistory = completions.filter { it.routine_id == routine.id }.map { it.toDomainModel() }
            )
        }
    }

    fun toggleRoutineCompleted(routineWithStatus: RoutineWithStatus) {
        if (routineWithStatus.routineCompletion != null) {
            completionsDb.deleteCompletion(routineWithStatus.routineCompletion.id)
        } else {
            completionsDb.insertCompletion(routineWithStatus.routine.id, dateTimeRepository.today())
        }
    }

    suspend fun createRoutine(name: String, description: String, interval: RoutineInterval, icon: RoutineIcon) {
        routinesDb.insertRoutine(name, description, interval.name, icon.dbKey)
    }

    suspend fun deleteRoutine(id: Int) = routinesDb.deleteRoutine(id)

    fun getTestRoutine() = routinesDb.testRoutine().toDomainModel()
}