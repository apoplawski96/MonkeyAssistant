package ap.droidsoft.monkeyassistant

import ap.droidsoft.monkeyassistant.cache.AndroidDatabaseDriverFactory
import ap.droidsoft.monkeyassistant.cache.Database
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {
        Database(databaseDriverFactory = AndroidDatabaseDriverFactory(androidContext()))
    }
}