package live.pro11.app.game.sharedComponant.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun MainButton(
    onClick: () -> Unit,
    enabled: Boolean,
    cornerRadius: Int = 5,
    label: String, // Button label text
    modifier: Modifier = Modifier // Modifier for the button to customize it
) {
    Button(
        onClick = onClick,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            contentColor = if (enabled) Color.White else Color.Gray, // Text color
            containerColor = if (enabled) Color.Red else Color.Gray // Background color
        ),
        shape = RoundedCornerShape(cornerRadius.dp),  // Set corner radius to 5dp
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .then(modifier) // Apply additional modifier if passed
    ) {
        Text(text = label, color = Color.White) // Label for the button
    }
}

