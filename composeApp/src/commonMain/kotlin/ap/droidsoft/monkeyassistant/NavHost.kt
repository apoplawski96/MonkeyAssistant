package ap.droidsoft.monkeyassistant

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ap.droidsoft.monkeyassistant.presentation.screens.routines.RoutinesScreen
import kotlinx.serialization.Serializable

@Serializable
object Routines
@Serializable
object RoutinesHistory

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routines) {
        composable<Routines> { RoutinesScreen() }
    }
}