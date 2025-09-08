package ap.droidsoft.monkeyassistant.presentation.screens.history

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ap.droidsoft.monkeyassistant.data.repository.RoutinesRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn

class RoutinesHistoryViewModel(routinesRepository: RoutinesRepository) : ViewModel() {

    val routinesHistoryUi = routinesRepository
        .getRoutinesHistory()
        .stateIn(viewModelScope, SharingStarted.Lazily, emptyList())
}