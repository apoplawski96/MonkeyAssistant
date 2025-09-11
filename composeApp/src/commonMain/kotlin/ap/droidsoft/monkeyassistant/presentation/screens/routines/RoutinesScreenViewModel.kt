package ap.droidsoft.monkeyassistant.presentation.screens.routines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ap.droidsoft.monkeyassistant.data.model.RoutineWithStatus
import ap.droidsoft.monkeyassistant.data.repository.RoutinesRepository
import ap.droidsoft.monkeyassistant.presentation.model.RoutineUIModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class RoutinesScreenViewModel(
    private val routinesRepository: RoutinesRepository,
) : ViewModel() {

    val routinesSections = routinesRepository
        .getRoutinesWithCompletionStatus()
        .map { routines ->
            routines
                .groupBy { it.routine.routineInterval }
                .map { (interval, routinesInInterval) ->
                    RoutinesSection(
                        interval = interval,
                        routines = routinesInInterval
                    )
                }
                .sortedBy { section ->
                    // Sort sections by interval order (Daily, Weekly, WorkingDays, Monthly, AdHoc, Custom)
                    section.interval.ordinal
                }
        }
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            emptyList()
        )

    fun toggleRoutineCompleted(routine: RoutineWithStatus) {
        routinesRepository.toggleRoutineCompleted(routine)
    }
}