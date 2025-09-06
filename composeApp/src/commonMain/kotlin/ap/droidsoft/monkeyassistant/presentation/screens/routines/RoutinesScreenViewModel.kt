package ap.droidsoft.monkeyassistant.presentation.screens.routines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import ap.droidsoft.monkeyassistant.data.repository.RoutinesRepository
import ap.droidsoft.monkeyassistant.getPlatform
import ap.droidsoft.monkeyassistant.presentation.model.RoutineUIModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn

class RoutinesScreenViewModel(
    private val routinesRepository: RoutinesRepository,
) : ViewModel() {

    private val _routinesUi = routinesRepository
        .getRoutinesWithCompletions()
        .stateIn(
            viewModelScope, SharingStarted.Lazily, emptyList()
        )

    private val _state = MutableStateFlow(RoutinesScreenUIState(""))
    val state = _state.asStateFlow()

    init {
        _state.value = RoutinesScreenUIState(
            testMessage = getPlatform().name,
            testRoutine = routinesRepository.getTestRoutine(),
        )
    }

    fun toggleRoutineCompleted(routine: RoutineUIModel) {
        if (routine.isCompleted) {

        } else {

        }
    }
}