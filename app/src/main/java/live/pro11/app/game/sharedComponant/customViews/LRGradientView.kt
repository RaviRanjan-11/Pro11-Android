package live.pro11.app.game.sharedComponant.customViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun TBGradientView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        Color.Red,
                        Color(0xFF800000) // Dark red
                    )
                )
            )
    )
}

@Composable
fun LRGradientView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFFB30000), // Lighter red
                        Color(0xFF660000)  // Dark red
                    )
                )
            )
    )
}

@Composable
fun LRDGradientView() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.horizontalGradient(
                    colors = listOf(
                        Color(0xFF800000), // Medium dark red
                        Color(0xFF330000)  // Darker red
                    )
                )
            )
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTBGradientView() {
    TBGradientView()
}

@Preview(showBackground = true)
@Composable
fun PreviewLRGradientView() {
    LRGradientView()
}

@Preview(showBackground = true)
@Composable
fun PreviewLRDGradientView() {
    LRDGradientView()
}

