package ap.droidsoft.monkeyassistant.presentation

import ap.droidsoft.monkeyassistant.presentation.screens.routines.RoutinesScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::RoutinesScreenViewModel)
}