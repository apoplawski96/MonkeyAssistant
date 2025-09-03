package ap.droidsoft.monkeyassistant.data.repository

import ap.droidsoft.monkeyassistant.data.cache.RoutinesDatabase
import ap.droidsoft.monkeyassistant.data.toDomainModel
import ap.droidsoft.monkeyassistant.domain.model.RoutineInterval

class RoutinesRepository(private val database: RoutinesDatabase) {

    fun getAllRoutines() = database.getAllRoutines().map { it.toDomainModel() }

    fun createRoutine(name: String, description: String, interval: RoutineInterval) =
        database.insertRoutine(name, description, interval.name)

    fun deleteRoutine(id: Int) = database.deleteRoutine(id)

    fun getTestRoutine() = database.testRoutine().toDomainModel()
}