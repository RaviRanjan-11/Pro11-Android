package live.pro11.app.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import live.pro11.app.game.navigation.AppNavigation
import live.pro11.app.game.Screens.ui.onboarding.Splash.SplashScreen
import live.pro11.app.game.ui.theme.Pro11Theme
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Pro11Theme {
                val navController = rememberNavController()
                AppNavigation(navController)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Pro11Theme {
        SplashScreen(rememberNavController())
    }
}
