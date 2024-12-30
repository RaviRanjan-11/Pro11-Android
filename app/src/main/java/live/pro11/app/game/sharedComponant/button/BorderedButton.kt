package live.pro11.app.game.sharedComponant.button

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun BorderedButton(
    titleColor: Color,
    title: String,
    onClick: () -> Unit,
    borderColor: Color = Color.Gray,
    modifier: Modifier = Modifier,
    cornerRadius: Int = 5
    ) {

    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth()
            .border(width = 2.dp, color = borderColor, shape = RoundedCornerShape(cornerRadius.dp)),


        shape = RoundedCornerShape(cornerRadius.dp),
        colors = ButtonDefaults.buttonColors(
            contentColor =  Color.Red, // Text color
            containerColor = Color.Transparent
        ),



    ) {
        Text(text = title, color = borderColor)

    }
}


@Preview(showBackground = true)
@Composable
fun ShowBorderedButton() {
    BorderedButton(
        titleColor = Color.Red,
        title = "Create a new Account",
        onClick = {},
        borderColor = Color.Gray,
        modifier = Modifier

    )
}