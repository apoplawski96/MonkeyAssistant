package ap.droidsoft.monkeyassistant.presentation.screens.routines

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import ap.droidsoft.monkeyassistant.data.repository.RoutinesRepository
import ap.droidsoft.monkeyassistant.getPlatform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class RoutinesScreenViewModel(
    private val routinesRepository: RoutinesRepository,
) : ViewModel() {

    private val _state = MutableStateFlow(RoutinesScreenUIState(""))
    val state = _state.asStateFlow()

    init {
        _state.value = RoutinesScreenUIState(
            testMessage = getPlatform().name,
            testRoutine = routinesRepository.getTestRoutine(),
        )
    }
}