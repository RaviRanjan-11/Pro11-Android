package live.pro11.app.game.sharedComponant.loader

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseProgressIndicator

@Composable
fun Pro11Loader() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black.copy(alpha = 0.1f)), // Dim background for better visibility
        contentAlignment = Alignment.Center // Centering the loader
    ) {
        BallPulseProgressIndicator(
            modifier = Modifier.size(100.dp), // Adjust size for better visibility
            color = Color.Red,
            animationDuration = 800,
            animationDelay = 200,
            startDelay = 0,
            ballCount = 3
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ShowLoader() {
    Pro11Loader()
}