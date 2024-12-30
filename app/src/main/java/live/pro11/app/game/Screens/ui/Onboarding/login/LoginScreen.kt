package live.pro11.app.game.Screens.ui.Onboarding.login

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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

@Composable
fun LoginScreen(navController: NavController) {

    var email by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var isButtonEnabled by remember { mutableStateOf(true) }

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


                    ProTextField(value = email,
                        onValueChange = { newText -> email = newText },
                        keyboardType = KeyboardType.Email,
                        placeholder = "Enter your email",
                        modifier = Modifier.padding(bottom = 16.dp)

                    )
                    ProCheckBoxWithLabel(checked = isChecked,
                        label = "I certify that I am 18 and above",
                        onCheckedChange = { newValue -> isChecked = newValue}
                    )

                    MainButton(
                        label = "Submit",
                        enabled = isButtonEnabled,
                        onClick = {
                            navController.navigate(Screen.OtpScreen.route)
                        }
                    )

                    Column(
                        modifier = Modifier
                            .padding(10.dp),
                        horizontalAlignment = Alignment.CenterHorizontally, // Center content horizontally
                        verticalArrangement = Arrangement.Center // C


                    ) {
                        TermsAndConditionsText()
                        Spacer(modifier = Modifier.height(16.dp)) // Adds space between the two items

                        OrDividerView()
                    }

                    BorderedButton(
                        titleColor = Color.Red,
                        onClick = {
                            navController.navigate(Screen.Register.route)  // Correct usage

                        },
                        title = "Create a new Account",
                        borderColor = Color.Gray,
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp))


                }
            }
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    val mockNavController = rememberNavController() // Use a mock NavController for Preview
    LoginScreen(navController = mockNavController)
}