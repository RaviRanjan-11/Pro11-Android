package live.pro11.app.game.sharedComponant.customViews

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TermsAndConditionsText() {
    val text = buildAnnotatedString {
        append("By continuing, I agree to Pro11's ")
        withStyle(style = SpanStyle(color = Color.Red, textDecoration = TextDecoration.Underline)) {
            append("T&C")
        }
    }

    Text(
        text = text,
        fontSize = 12.sp,
        color = Color.Gray,
        modifier = Modifier.padding(top = 10.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun ShowTermsAndConditionsText() {
    TermsAndConditionsText()
}