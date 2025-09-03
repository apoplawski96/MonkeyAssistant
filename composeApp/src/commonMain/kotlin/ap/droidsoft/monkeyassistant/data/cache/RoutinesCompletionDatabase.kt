package ap.droidsoft.monkeyassistant.data.cache

import ap.droidsoft.monkeyassistant.cache.Database
import ap.droidsoft.monkeyassistant.cache.Routine_completion

internal class RoutinesCompletionDatabase(private val database: Database) {

    internal fun getCompletionByRoutine(routineId: Int) =
        database.completionQueries.completionsByRoutine(routineId.toLong())

    internal fun getCompletionsByDate(completedOnDate: String) =
        database.completionQueries.completionsByDate(completedOnDate)

    internal fun insertCompletion(completion: Routine_completion) =
        database.completionQueries.insertCompletion(
            completion.routine_id,
            completion.completed_on,
        )

    internal fun deleteCompletion(id: Int) =
        database.completionQueries.deleteCompletion(id.toLong())
}