package ap.droidsoft.monkeyassistant.presentation

import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::RoutinesScreenViewModel)
}