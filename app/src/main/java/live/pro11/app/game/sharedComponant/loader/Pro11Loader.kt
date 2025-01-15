package live.pro11.app.game.sharedComponant.loader

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.ehsanmsz.mszprogressindicator.progressindicator.BallGridPulseProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.BallPulseProgressIndicator
import com.ehsanmsz.mszprogressindicator.progressindicator.LineSpinFadeLoaderProgressIndicator


@Composable
fun Pro11Loader() {
    BallPulseProgressIndicator(
        modifier = Modifier,
        color = Color.Red,
        animationDuration = 800,
        animationDelay = 200,
        startDelay = 0,
        ballCount = 3,
    )
}

@Preview(showBackground = true)
@Composable
fun ShowLoader() {
    Pro11Loader()
}