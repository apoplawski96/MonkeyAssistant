package ap.droidsoft.monkeyassistant.data.repository

import ap.droidsoft.monkeyassistant.data.cache.CompletionDatabase
import ap.droidsoft.monkeyassistant.data.cache.RoutinesDatabase
import ap.droidsoft.monkeyassistant.data.model.RoutineWithStatus
import ap.droidsoft.monkeyassistant.data.toDomainModel
import ap.droidsoft.monkeyassistant.domain.model.RoutineCompletion
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine

class RoutinesRepository(
    private val routinesDb: RoutinesDatabase,
    private val completionsDb: CompletionDatabase,
) {

    fun getRoutinesWithCompletions() : Flow<List<RoutineWithStatus>> = combine(
        routinesDb.getAllRoutines(),
        completionsDb.getAllCompletions(),
    ) { routines, completions ->
        routines.map { routine ->
            val hasCompleted = completions.any { completion ->
                completion.routine_id == routine.id
//                        && completion.completed_on == "TODAY" // TODO
            }
            RoutineWithStatus(routine.toDomainModel(), hasCompleted)
        }
    }

//    fun toggleRoutineCompleted() {
//        completionsDb.insertCompletion(RoutineCompletion())
//    }

    fun createRoutine(name: String, description: String, interval: RoutineInterval) =
        routinesDb.insertRoutine(name, description, interval.name)

    fun deleteRoutine(id: Int) = routinesDb.deleteRoutine(id)

    fun getTestRoutine() = routinesDb.testRoutine().toDomainModel()
}