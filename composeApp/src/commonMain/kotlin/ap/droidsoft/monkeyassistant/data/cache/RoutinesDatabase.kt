package ap.droidsoft.monkeyassistant.data.cache

import ap.droidsoft.monkeyassistant.DbDispatcher
import ap.droidsoft.monkeyassistant.cache.Database
import ap.droidsoft.monkeyassistant.cache.Routine
import app.cash.sqldelight.coroutines.asFlow
import app.cash.sqldelight.coroutines.mapToList

class RoutinesDatabase(private val database: Database) {

    internal fun getAllRoutines() =
        database.routineQueries.allRoutines().asFlow().mapToList(DbDispatcher)

    internal fun getRoutineById(id: Int): Routine? =
        database.routineQueries.routineById(id.toLong()).executeAsOneOrNull()

    internal fun insertRoutine(name: String, description: String, interval: String) =
        database.routineQueries.insertRoutine(
            name = name,
            description = description,
            routine_interval = interval,
        )

    internal fun deleteRoutine(id: Int) {
        database.routineQueries.deleteRoutine(id.toLong())
    }

    internal fun testRoutine() = Routine(1, "Test Routine", "This is a test routine", "Daily")
}