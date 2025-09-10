package ap.droidsoft.monkeyassistant

import kotlinx.serialization.Serializable

sealed interface Routes {
    @Serializable
    object Routines
    @Serializable
    object RoutinesHistory
    @Serializable
    object CreateRoutine
}