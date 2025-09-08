package ap.droidsoft.monkeyassistant.data.cache

import ap.droidsoft.monkeyassistant.DbDispatcher
import ap.droidsoft.monkeyassistant.cache.Database
import ap.droidsoft.monkeyassistant.cache.Routine_completion
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList

class CompletionDatabase(private val database: Database) {

    internal fun getAllCompletions() =
        database.completionQueries.allCompletions().asFlow().mapToList(DbDispatcher)

    internal fun getCompletionByRoutine(routineId: Int) =
        database.completionQueries.completionsByRoutine(routineId.toLong())

    internal fun getCompletionsByDate(completedOnDate: String) =
        database.completionQueries.completionsByDate(completedOnDate)

    internal fun insertCompletion(routineId: Int, completedOnDate: String) =
        database.completionQueries.insertCompletion(
            routineId.toLong(),
            completedOnDate,
        )

    internal fun deleteCompletion(id: Int) =
        database.completionQueries.deleteCompletion(id.toLong())
}