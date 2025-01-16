package live.pro11.app.game.Screens.ui.onboarding.login

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import live.pro11.app.game.navigation.Screen
import live.pro11.app.game.sharedComponant.button.BorderedButton
import live.pro11.app.game.sharedComponant.button.ProCheckBoxWithLabel
import live.pro11.app.game.sharedComponant.button.MainButton
import live.pro11.app.game.sharedComponant.customViews.OrDividerView
import live.pro11.app.game.sharedComponant.navigationBar.NavigationBar
import live.pro11.app.game.sharedComponant.textField.ProTextField
import live.pro11.app.game.sharedComponant.customViews.TermsAndConditionsText
import androidx.hilt.navigation.compose.hiltViewModel
import live.pro11.app.game.common.universal.alert.TimedAlertDialog
import live.pro11.app.game.sharedComponant.loader.Pro11Loader

@Composable
fun LoginScreen(navController: NavController, viewModel: LoginViewModel = hiltViewModel()) {

    val isLoading by viewModel.isLoading.collectAsState()
    val errorMessage = remember { mutableStateOf<String?>(null) }



    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            NavigationBar(title = "Login")
            // Login content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .padding(16.dp)
                ) {
                    Text(
                        "Enter Registered Email",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        "We will send the OTP (One Time Password)",
                        fontSize = 12.sp, color = Color.Gray,
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                    )


                    ProTextField(value = viewModel.email,
                        onValueChange = { newText -> viewModel.onEmailChange(newText) }, // Use ViewModel method
                        keyboardType = KeyboardType.Email,
                        placeholder = "Enter your email",
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                    ProCheckBoxWithLabel(
                        checked = viewModel.isChecked,
                        label = "I certify that I am 18 and above",
                        onCheckedChange = { newValue -> viewModel.onCheckboxChange(newValue) } // Use ViewModel method
                    )

                    MainButton(
                        label = "Submit",
                        enabled = viewModel.isButtonEnabled,
                        onClick = {
                            println("On Click login")
                            viewModel.loginUser(
                                onLoginSuccess = {
                                    // Navigate to OTP screen when login is successful
                                    Log.d("Here are the detail for otp ${viewModel.email} ${viewModel.loginToken}", "Login successful")
                                    navController.navigate(Screen.OtpScreen.route+ "/${viewModel.email}/${viewModel.loginToken}")
                                },
                                onLoginError = { message ->
                                    // Set error message when login fails
                                    errorMessage.value = message
                                    print(message)
                                }
                            )
                        }
                    )

                    Column(
                        modifier = Modifier
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        TermsAndConditionsText()
                        Spacer(modifier = Modifier.height(16.dp)) // Adds space between the two items
                        OrDividerView()
                    }

                    BorderedButton(
                        titleColor = Color.Red,
                        onClick = {
                            navController.navigate(Screen.Register.route)
                        },
                        title = "Create a new Account",
                        borderColor = Color.Gray,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp)
                    )
                }
                if (isLoading) {
                    Pro11Loader()
                }

            }
        }
    }
    // Show the alert dialog only if there's an error message
    errorMessage.value?.let { message ->
        TimedAlertDialog(
            message = message,
            onDismiss = { errorMessage.value = null }
        )
    }
}

@Preview
@Composable
fun LoginPreview() {
    val mockNavController = rememberNavController() // Use a mock NavController for Preview
    LoginScreen(navController = mockNavController)
}