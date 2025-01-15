package live.pro11.app.game.sharedComponant.textField

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ProTextField(
    value: String, // The value should be the actual user input
    onValueChange: (String) -> Unit,
    keyboardType: KeyboardType,
    cornerRadius: Int = 5,
    placeholder: String = "",
    modifier: Modifier = Modifier
) {
    TextField(
        value = value, // Bind the state variable for the value
        onValueChange = onValueChange,
        placeholder = {
            Text(text = placeholder) // Show placeholder text
        },
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = keyboardType),
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        modifier = modifier
            .fillMaxWidth()
            .background(
                color = Color.White,
                shape = RoundedCornerShape(cornerRadius.dp)
            )
            .border(1.dp, Color.Gray, RoundedCornerShape(cornerRadius.dp))
            .height(50.dp)
    )
}

@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ProTextFieldPreview() {
    ProTextField(
        value = "email",
        onValueChange = {  },
        keyboardType = KeyboardType.Email,
        placeholder = "Enter your email",
//        modifier = Modifier.padding(bottom = 16.dp)

    )
}