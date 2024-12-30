package live.pro11.app.game.sharedComponant.button

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun ProCheckBoxWithLabel(
    checked: Boolean,
    label: String,
    onCheckedChange: (Boolean) -> Unit,
) {
    Row (
        verticalAlignment = Alignment.CenterVertically, // Align checkbox and text vertically
        horizontalArrangement = Arrangement.Start, // Align items to the left
        modifier = Modifier.padding(top = 16.dp, start = 5.dp)
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = onCheckedChange,
            modifier = Modifier.size(14.dp)


        )
        Text(
            text = label,
            style = TextStyle(fontSize = 16.sp),
            fontSize = 12.sp,
            color = Color.Gray,
            modifier = Modifier.padding(start = 15.dp)
        )
    }
}



@Preview(showBackground = true)
@Composable
fun CheckBoxPreview(){
    ProCheckBoxWithLabel(
        checked = true,
        label = "I certify that I am 18 and above",
        onCheckedChange = {})
}