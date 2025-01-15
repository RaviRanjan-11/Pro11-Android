package live.pro11.app.game.Screens.ui.onboarding.otp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import live.pro11.app.game.R
import live.pro11.app.game.navigation.Screen
import live.pro11.app.game.sharedComponant.button.MainButton
import live.pro11.app.game.sharedComponant.navigationBar.NavigationBar
import live.pro11.app.game.sharedComponant.textField.ProTextField

@Composable
fun OTPScreen(navController: NavController, viewModel: OTPViewModel = hiltViewModel()) {

    Scaffold { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)
        ) {
            NavigationBar(title = "Verify OTP")

            // Box with background and corner radius
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(
                        Color(0xFF0000FF)
                            .copy(alpha = 0.1f),
                        shape = RoundedCornerShape(5.dp)
                    )

            ) {
                Column {
                    Column(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        Text("Enter the 6 digit otp sent to your email")

                        Row(
                            modifier = Modifier
                                .fillMaxWidth(),
                            horizontalArrangement = Arrangement.Start, // Align items to the leading edge
                            verticalAlignment = Alignment.CenterVertically // Align items vertically at the center
                        ) {
                            Text(
                                "myubuntuu@hgmail.com",
                                color = Color.Gray,
                                fontSize = 12.sp,
                                fontWeight = FontWeight.Bold
                            )

                            Button(
                                onClick = {
                                    navController.popBackStack()
                                },
                                colors = ButtonDefaults.buttonColors(
                                    contentColor = Color.Red, // Text color (icon color)
                                    containerColor = Color.Transparent // Transparent background
                                ),
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.pencil),
                                    contentDescription = null,
                                    modifier = Modifier.size(25.dp)
                                )
                            }
                        }

                        ProTextField(
                            value = viewModel.otpValue,
                            onValueChange = { newValue -> viewModel.otpValue = newValue },
                            keyboardType = KeyboardType.Text,
                            cornerRadius = 5,
                            placeholder = "Enter OTP"
                        )
                    }

                }


            }
            MainButton(
                onClick = {
                    navController.navigate(Screen.HomeTabBar.route)
                },
                enabled = true,
                label = "Submit",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable

fun ShowOTPScreen() {
    val mockNavController = rememberNavController()
    OTPScreen(navController = mockNavController)

}