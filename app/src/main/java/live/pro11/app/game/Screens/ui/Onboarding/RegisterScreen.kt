package live.pro11.app.game.Screens.ui.Onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import live.pro11.app.game.sharedComponant.button.MainButton
import live.pro11.app.game.sharedComponant.button.ProCheckBoxWithLabel
import live.pro11.app.game.sharedComponant.customViews.TermsAndConditionsText
import live.pro11.app.game.sharedComponant.navigationBar.NavigationBar
import live.pro11.app.game.sharedComponant.textField.ProTextField

@Composable
fun RegisterScreen(navController: NavController,
                   modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var mobile by remember { mutableStateOf("") }
    var referralCode by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var isButtonEnabled by remember { mutableStateOf(true) }

    Scaffold { innerPadding ->

        Column(modifier = Modifier.padding(innerPadding)
            ) {
            NavigationBar(title = "Register")

            Column(modifier = Modifier
                .padding(16.dp)) {
            ProTextField(
                value = name,
                onValueChange = { newText -> name = newText },  // Corrected to update 'name'
                keyboardType = KeyboardType.Text,
                placeholder = "Enter your name",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProTextField(
                value = email,
                onValueChange = { newText -> email = newText },
                keyboardType = KeyboardType.Email,
                placeholder = "Enter your email",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProTextField(
                value = mobile,
                onValueChange = { newText -> mobile = newText },
                keyboardType = KeyboardType.Phone,
                placeholder = "Enter your mobile number",
                modifier = Modifier.padding(bottom = 16.dp)
            )

            ProTextField(
                value = referralCode,
                onValueChange = { newText ->
                    referralCode = newText
                }, // Corrected to update 'referralCode'
                keyboardType = KeyboardType.Text,
                placeholder = "Enter your referral code",
                modifier = Modifier.padding(bottom = 16.dp)
            )


                ProCheckBoxWithLabel(checked = isChecked,
                    label = "I certify that I am 18 and above",
                    onCheckedChange = { newValue -> isChecked = newValue}
                )
                MainButton(
                    label = "Submit",
                    enabled = isButtonEnabled,
                    onClick = {},
                    modifier = modifier.padding(top = 10.dp)
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
    }
}




@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ShowRegisterScreen(){
    val mockNavController = rememberNavController() // Use a mock NavController for Preview

    RegisterScreen(navController = mockNavController)

}