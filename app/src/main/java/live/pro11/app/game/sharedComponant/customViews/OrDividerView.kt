package live.pro11.app.game.sharedComponant.customViews

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun OrDividerView() {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp), // Add some horizontal padding
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center // Center the content horizontally
    ) {
        // Left Line
        Divider(
            modifier = Modifier
                .weight(1f) // This ensures the line takes up the remaining space on the left side
                .height(1.dp)
                .background(Color.Gray) // Color of the line
        )

        // OR Text
        Text(
            text = "OR",
            modifier = Modifier.padding(horizontal = 16.dp), // Add spacing around the text
            color = Color.Gray,
            fontSize = 14.sp
        )

        // Right Line
        Divider(
            modifier = Modifier
                .weight(1f) // This ensures the line takes up the remaining space on the right side
                .height(1.dp)
                .background(Color.Gray) // Color of the line
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ShowOrDividerView() {
    OrDividerView()
}