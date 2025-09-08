package ap.droidsoft.monkeyassistant.presentation.screens.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ap.droidsoft.monkeyassistant.data.repository.RoutinesRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CreateRoutineViewModel(private val routinesRepository: RoutinesRepository) : ViewModel() {

    private val _creatingFinished = MutableStateFlow(false)
    val creatingFinished = _creatingFinished.asStateFlow()

    private val _inputs = MutableStateFlow(CreateRoutineScreenUIState())
    val inputs = _inputs.asStateFlow()

    val isFormValid = inputs.map { it.nameInput.isNotBlank() }
        .stateIn(viewModelScope, SharingStarted.Lazily, false)

    fun createRoutine() {
        if (isFormValid.value.not()) return

        viewModelScope.launch {
            routinesRepository.createRoutine(
                name = inputs.value.nameInput,
                description = inputs.value.descriptionInput,
                interval = inputs.value.intervalInput,
                icon = inputs.value.iconInput,
            )
            _creatingFinished.value = true
        }
    }
}