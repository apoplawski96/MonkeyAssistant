package ap.droidsoft.monkeyassistant.cache

class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(databaseDriverFactory.createDriver())
    val routineQueries = database.routineQueries
    val completionQueries = database.routineCompletionQueries
}