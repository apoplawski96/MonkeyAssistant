package ap.droidsoft.monkeyassistant

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform