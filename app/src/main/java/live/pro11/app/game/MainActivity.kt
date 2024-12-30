package live.pro11.app.game

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import live.pro11.app.game.navigation.AppNavigation
import live.pro11.app.game.Screens.ui.Onboarding.SplashScreen
import live.pro11.app.game.ui.theme.Pro11Theme
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
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