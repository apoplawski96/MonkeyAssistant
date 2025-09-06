package ap.droidsoft.monkeyassistant

import android.os.Build
import kotlinx.coroutines.Dispatchers

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual val DbDispatcher = Dispatchers.IO