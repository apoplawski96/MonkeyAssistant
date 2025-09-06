package ap.droidsoft.monkeyassistant

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ap.droidsoft.monkeyassistant.presentation.screens.routines.RoutinesScreenViewModel
import ap.droidsoft.monkeyassistant.presentation.theme.getColorScheme
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import monkeyassistant.composeapp.generated.resources.Res
import monkeyassistant.composeapp.generated.resources.compose_multiplatform
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App(
    viewModel: RoutinesScreenViewModel = koinViewModel()
) {
//    val state by viewModel.state.collectAsStateWithLifecycle()
//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                    Text("Data from data layer: ${state.testRoutine}, message: ${state.testMessage}")
//                }
//            }
//        }
//    }
    MaterialTheme(colorScheme = getColorScheme(darkTheme = true)) {
        AppNavHost()
    }
}