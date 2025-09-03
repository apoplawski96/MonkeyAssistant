package ap.droidsoft.monkeyassistant

import android.app.Application
import ap.droidsoft.monkeyassistant.data.dataModule
import ap.droidsoft.monkeyassistant.presentation.presentationModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MainApplication)
            modules(appModule, dataModule, presentationModule)
        }
    }
}