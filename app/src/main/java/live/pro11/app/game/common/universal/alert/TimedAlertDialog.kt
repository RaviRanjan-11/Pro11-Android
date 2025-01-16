package live.pro11.app.game.common.universal.alert

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TimedAlertDialog(
    message: String,
    onDismiss: () -> Unit
) {
    val coroutineScope = rememberCoroutineScope()
    val showDialog = remember { mutableStateOf(true) }

    // Automatically dismiss the dialog after 60 seconds
    LaunchedEffect(showDialog.value) {
        if (showDialog.value) {
            coroutineScope.launch {
                delay(60000L) // 60 seconds delay
                showDialog.value = false
                onDismiss()
            }
        }
    }

    if (showDialog.value) {
        AlertDialog(
            onDismissRequest = {
                showDialog.value = false
                onDismiss()
            },
            text = { Text(text = message) },
            confirmButton = {
                TextButton(onClick = {
                    showDialog.value = false
                    onDismiss()
                }) {
                    Text("OK")
                }
            }
        )
    }
}

@Composable
fun AlertDialogDemo() {
    var showDialog by remember { mutableStateOf(true) }

    if (showDialog) {
        TimedAlertDialog(
            message = "This alert will disappear in 60 seconds or when tapped!",
            onDismiss = { showDialog = false }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAlertDialog() {
    AlertDialogDemo()
}
