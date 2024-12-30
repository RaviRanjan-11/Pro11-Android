package live.pro11.app.game.sharedComponant.navigationBar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.TextStyle
//import androidx.compose.foundation.layout.FlowColumnScopeInstance.align
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.sp
import live.pro11.app.game.R
import live.pro11.app.game.sharedComponant.customViews.LRDGradientView


@Composable
fun NavigationBar(title: String = "Login") {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(60.dp) // Set a height for the navigation bar
    ) {
        // Add LRDGradientView as the background
        LRDGradientView()

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp), // Add padding inside the bar
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Image Section (Logo)
            Image(
                painter = painterResource(id = R.drawable.pro11),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(45.dp)
                    .clip(CircleShape) // Circular image
            )

            Spacer(modifier = Modifier.width(15.dp)) // Spacer between image and title

            // Title Section
            Text(
                text = title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Color.White
                )
            )
        }
    }
}



@Preview(showBackground = true)
@Composable
fun NavigationBarPreview() {
    NavigationBar()
}