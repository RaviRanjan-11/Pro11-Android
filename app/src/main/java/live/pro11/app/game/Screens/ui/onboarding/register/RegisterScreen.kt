package live.pro11.app.game.Screens.ui.onboarding.register

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import live.pro11.app.game.common.universal.alert.TimedAlertDialog
import live.pro11.app.game.navigation.Screen
import live.pro11.app.game.sharedComponant.button.MainButton
import live.pro11.app.game.sharedComponant.button.ProCheckBoxWithLabel
import live.pro11.app.game.sharedComponant.loader.Pro11Loader
import live.pro11.app.game.sharedComponant.navigationBar.NavigationBar
import live.pro11.app.game.sharedComponant.textField.ProTextField

@Composable
fun RegisterScreen(navController: NavController, viewModel: RegisterViewModel = hiltViewModel()) {

    val errorMessage = remember { mutableStateOf<String?>(null) }
    val isLoading by viewModel.isLoading.collectAsState()


    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavigationBar(title = "Register")

            Column(modifier = Modifier
                .padding(16.dp)) {
            ProTextField(
                value = viewModel.name,
                onValueChange = { newText -> viewModel.onNameChange(newText) },
                keyboardType = KeyboardType.Text,
                placeholder = "Enter your name",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProTextField(
                value = viewModel.email,
                onValueChange = { newText -> viewModel.onEmailChange(newText) },
                keyboardType = KeyboardType.Email,
                placeholder = "Enter your email",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProTextField(
                value = viewModel.mobile,
                onValueChange = { newText -> viewModel.onMobileChange(newText) },
                keyboardType = KeyboardType.Phone,
                placeholder = "Enter your mobile number",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProTextField(
                value = viewModel.referralCode,
                onValueChange = { newText ->
                    viewModel.onReferralCodeChange(newText)
                },
                keyboardType = KeyboardType.Text,
                placeholder = "Enter your referral code",
                modifier = Modifier.padding(bottom = 16.dp)
            )


                ProCheckBoxWithLabel(checked = viewModel.isChecked,
                    label = "I certify that I am 18 and above",
                    onCheckedChange = { newValue -> viewModel.onCheckedChange(newValue)}
                )

                MainButton(
                    label = "Submit",
                    enabled = viewModel.isButtonEnabled,
                    onClick = {
                        viewModel.registerUser(
                            onRegisterSuccess = {
                                navController.popBackStack()
                            },
                            onRegisterError = { message ->
                                // Set error message when login fails
                                errorMessage.value = message
                                print(message)
                            }
                        )

                    },
                    modifier = Modifier.padding(top = 10.dp)
                )
                Button(onClick = {
                    navController.popBackStack()
                },
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Transparent, // Text color
                        containerColor =  Color.Transparent // Background color
                    ),
                    modifier = Modifier
                        .fillMaxWidth()

                ) {
                    Text("Back to Login", color = Color.Gray)
                }
            }
        }
        if (isLoading) {
            Pro11Loader()
        }
    }
//    Show the alert dialog only if there's an error message
    errorMessage.value?.let { message ->
        TimedAlertDialog(
            message = message,
            onDismiss = { errorMessage.value = null })
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowRegisterScreen(){
    val mockNavController = rememberNavController() // Use a mock NavController for Preview

    RegisterScreen(navController = mockNavController)

}