package ap.droidsoft.monkeyassistant.data

import ap.droidsoft.monkeyassistant.cache.Database
import ap.droidsoft.monkeyassistant.data.cache.RoutinesCompletionDatabase
import ap.droidsoft.monkeyassistant.data.cache.RoutinesDatabase
import ap.droidsoft.monkeyassistant.data.repository.RoutinesRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module

val dataModule = module {
    // Db helpers
    singleOf(::RoutinesDatabase)
    singleOf(::RoutinesCompletionDatabase)
    // Repositories
    singleOf(::RoutinesRepository)
}