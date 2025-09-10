package ap.droidsoft.monkeyassistant.presentation

import ap.droidsoft.monkeyassistant.presentation.screens.create.CreateRoutineScreen
import ap.droidsoft.monkeyassistant.presentation.screens.create.CreateRoutineViewModel
import ap.droidsoft.monkeyassistant.presentation.screens.routines.RoutinesScreenViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val presentationModule = module {
    viewModelOf(::RoutinesScreenViewModel)
    viewModelOf(::CreateRoutineViewModel)
}