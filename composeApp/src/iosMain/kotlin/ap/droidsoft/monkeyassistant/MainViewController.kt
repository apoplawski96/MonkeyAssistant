package ap.droidsoft.monkeyassistant

import androidx.compose.ui.window.ComposeUIViewController
import ap.droidsoft.monkeyassistant.cache.DatabaseDriverFactory
import ap.droidsoft.monkeyassistant.cache.IOSDatabaseDriverFactory
import ap.droidsoft.monkeyassistant.data.dataModule
import ap.droidsoft.monkeyassistant.presentation.presentationModule
import org.koin.core.context.startKoin
import org.koin.dsl.module

fun MainViewController() = ComposeUIViewController {
    startKoin {
        module { single<DatabaseDriverFactory>{ IOSDatabaseDriverFactory() }}
        modules(dataModule, presentationModule)
    }
    App()
}