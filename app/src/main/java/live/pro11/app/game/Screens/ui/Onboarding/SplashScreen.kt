package live.pro11.app.game.Screens.ui.Onboarding

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.delay
import live.pro11.app.game.R
import live.pro11.app.game.navigation.Screen

@Composable
fun SplashScreen(navController: NavController) {
    val logoScale = remember { Animatable(0f) }
    val textOpacity = remember { Animatable(0f) }
    val fullText = "Encash your Mastery"

    LaunchedEffect(Unit) {
        logoScale.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 2000, easing = FastOutSlowInEasing)
        )
        delay(500)

        textOpacity.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 1000, easing = FastOutSlowInEasing)
        )

        delay(1000)
        navController.navigate(Screen.Login.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pro11),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .scale(logoScale.value)
            )
            Text(
                text = fullText,
                style = MaterialTheme.typography.headlineSmall,
                color = Color.Red,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .alpha(textOpacity.value)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewSplashScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.pro11),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .scale(1f) // Final scale for preview
            )

            Text(
                text = "Encash your Mastery",
                style = MaterialTheme.typography.headlineMedium,
                color = Color.Red,
                modifier = Modifier
                    .padding(top = 16.dp)
                    .alpha(1f) // Final opacity for preview
            )
        }
    }
}
