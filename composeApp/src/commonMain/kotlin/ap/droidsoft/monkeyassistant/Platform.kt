package ap.droidsoft.monkeyassistant

import kotlinx.coroutines.CoroutineDispatcher

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect val DbDispatcher: CoroutineDispatcher