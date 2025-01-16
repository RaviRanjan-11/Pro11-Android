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



    fun verifyOTP() {
        showLoader()  // Show the loader before making the API call
        Log.d("OTPViewModel", "Verifying OTP with: $otpValue, $email, $token")

        viewModelScope.launch {
            try {
                val response = otpService.verifyOTP(OTPRequest(otpValue, token, email))

                if (response.success) {
                    Log.d("Login Success", "User logged in successfully.")
                } else {
                    Log.e("OTP Failure", "Failed to verify OTP.")
                }
            } catch (e: Exception) {
                Log.e("Login Error", "Exception: ${e.message}", e)
            } finally {
                hideLoader()  // Hide the loader after the API call finishes
            }
        }
    }


}