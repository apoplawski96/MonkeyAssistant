package ap.droidsoft.monkeyassistant.presentation.screens.create

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ap.droidsoft.monkeyassistant.data.repository.RoutinesRepository
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval
import ap.droidsoft.monkeyassistant.presentation.model.RoutineIcon
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

    fun updateName(name: String) {
        _inputs.value = _inputs.value.copy(nameInput = name)
    }

    fun updateDescription(description: String) {
        _inputs.value = _inputs.value.copy(descriptionInput = description)
    }

    fun updateInterval(interval: RoutineInterval) {
        println("2137 - update interval: $interval")
        _inputs.value = _inputs.value.copy(intervalInput = interval)
    }

    fun updateIcon(icon: RoutineIcon) {
        println("2137 - update icon: $icon")
        _inputs.value = _inputs.value.copy(iconInput = icon)
    }

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