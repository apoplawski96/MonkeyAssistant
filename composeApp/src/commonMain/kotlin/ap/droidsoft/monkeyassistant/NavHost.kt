package ap.droidsoft.monkeyassistant

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ap.droidsoft.monkeyassistant.presentation.screens.create.CreateRoutineScreen
import ap.droidsoft.monkeyassistant.presentation.screens.routines.RoutinesScreen

@Composable
fun AppNavHost() {
    val navController = rememberNavController()
    NavHost(navController, startDestination = Routes.Routines) {
        composable<Routes.Routines> { RoutinesScreen(navController) }
        composable<Routes.CreateRoutine> { CreateRoutineScreen(navController) }
    }
}