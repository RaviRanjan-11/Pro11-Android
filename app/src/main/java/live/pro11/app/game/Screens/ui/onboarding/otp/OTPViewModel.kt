package live.pro11.app.game.Screens.ui.onboarding.otp
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import live.pro11.app.game.Screens.ui.onboarding.auth.request.OTPRequest
import live.pro11.app.game.Screens.ui.onboarding.auth.service.OTPService
import live.pro11.app.game.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class OTPViewModel @Inject constructor(
    private val otpService: OTPService
): BaseViewModel() {

    var otpValue by mutableStateOf("")
    var email by mutableStateOf("")
    var token by mutableStateOf("")
    var isEnable by mutableStateOf(false)


    // Function to handle OTP input
    fun onOtpValueChange(newOtp: String) {
        otpValue = newOtp.take(6)  // Prevent more than 6 characters

        validateOTPRequest()
    }
    private fun validateOTPRequest() {
        isEnable = otpValue.isNotBlank() &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() && otpValue.length == 6
    }

    fun verifyOTP(onOTPSuccess: () -> Unit, onOTPError: (String) -> Unit) {

        showLoader()  // Show the loader before making the API call
        Log.d("OTPViewModel", "Verifying OTP with: $otpValue, $email, $token")

        viewModelScope.launch {
            try {
                val response = otpService.verifyOTP(OTPRequest(otpValue, token, email))
                onOTPSuccess()
                if (response.success) {
                    Log.d("Login Success", "User logged in successfully.")
                } else {
                    Log.e("OTP Failure", "Failed to verify OTP.")

                    val errorMessage = when (response.statusCode) {
                        500 -> "Internal Server Error: ${response.message}"
                        else -> "Error: ${response.error.joinToString()}"
                    }
                    onOTPError(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("Login Error", "Exception: ${e.message}", e)
                onOTPError("An unexpected error occurred: ${e.message}")
            } finally {
                hideLoader()  // Hide the loader after the API call finishes
            }
        }
    }

}