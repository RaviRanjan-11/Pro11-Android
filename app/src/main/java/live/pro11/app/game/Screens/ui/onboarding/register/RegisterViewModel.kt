package live.pro11.app.game.Screens.ui.onboarding.register

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import live.pro11.app.game.Screens.ui.onboarding.auth.request.RegisterationRequest
import live.pro11.app.game.Screens.ui.onboarding.auth.service.RegisterService
import live.pro11.app.game.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val registerService: RegisterService
) : BaseViewModel() {

    var token by mutableStateOf("")
        private set
    var email by mutableStateOf("")
        private set
    var name by mutableStateOf("")
        private set
    var mobile by mutableStateOf("")
        private set
    var referralCode by mutableStateOf("")
        private set
    var isChecked by mutableStateOf(false)
        private set
    var isButtonEnabled by mutableStateOf(false)
        private set

    // Function to update name and trigger validation
    fun onNameChange(newName: String) {
        name = newName
        validateFields()
    }

    // Function to update email and trigger validation
    fun onEmailChange(newEmail: String) {
        email = newEmail
        validateFields()
    }

    // Function to update mobile and trigger validation
    fun onMobileChange(newMobile: String) {
        mobile = newMobile
        validateFields()
    }

    // Function to update referral code (not mandatory)
    fun onReferralCodeChange(newCode: String) {
        referralCode = newCode
        validateFields()
    }

    // Function to update checkbox state and trigger validation
    fun onCheckedChange(newValue: Boolean) {
        isChecked = newValue
        validateFields()
    }

    // Private function to validate fields and enable/disable button
    private fun validateFields() {
        isButtonEnabled = email.isNotBlank()
                && name.isNotBlank()
                && mobile.isNotBlank()
                && isChecked
                &&  android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
                && android.util.Patterns.PHONE.matcher(mobile).matches()
    }


    fun registerUser(
        onRegisterSuccess: () -> Unit,
        onRegisterError: (String) -> Unit
    ) {

        val registerRequest =  RegisterationRequest(
            username = name,
            phoneNo = "+91$mobile",
            email = email,
            acceptedTermsAndConditions = isChecked,
            referralCode = referralCode )
        println(registerRequest)
        Log.d("Request ", registerRequest.toString())
        viewModelScope.launch {
            showLoader()
            try {
                val response = registerService.registerWithoutReferal(registerRequest)

                if (response.success) {
                    onRegisterSuccess()
                } else {
                    onRegisterError(response.error.joinToString())
                    hideLoader()
                }
            } catch (e: Exception) {
                onRegisterError("An error occurred: ${e.message}")
            } finally {
                hideLoader()
            }
        }
    }
}
