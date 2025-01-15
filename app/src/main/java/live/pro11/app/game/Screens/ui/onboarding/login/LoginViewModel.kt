package live.pro11.app.game.Screens.ui.onboarding.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import live.pro11.app.game.Screens.ui.onboarding.auth.request.LoginRequest
import live.pro11.app.game.Screens.ui.onboarding.auth.service.LoginService
import live.pro11.app.game.base.BaseViewModel
import live.pro11.app.game.storage.sharedPreference.SharedPreferenceKeys
import live.pro11.app.game.storage.sharedPreference.SharedPrefsManager
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginService: LoginService,
) : BaseViewModel() {

    var email by mutableStateOf("")
        private set

    var isChecked by mutableStateOf(false)
        private set

    var isButtonEnabled by mutableStateOf(false)
        private set

    fun onEmailChange(newEmail: String) {
        email = newEmail
        validateForm()
    }

    fun onCheckboxChange(newValue: Boolean) {
        isChecked = newValue
        validateForm()
    }

    private fun validateForm() {
        isButtonEnabled = email.isNotBlank() &&
                android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches() &&
                isChecked
    }

    fun loginUser(onLoginSuccess: () -> Unit, onLoginError: (String) -> Unit) {
        viewModelScope.launch {
            try {
                val response = loginService.login(LoginRequest(email))

                if (response.success) {
                    println("Login Successful: $response")
                    SharedPrefsManager.saveString(SharedPreferenceKeys.USER_TOKEN, response.responseDTO.token)
                    onLoginSuccess()
                } else {
                    if (response.statusCode == 500) {
                        onLoginError("Internal Server Error: ${response.message}")
                    } else {
                        // Handle other errors based on response
                        onLoginError("Error: ${response.error.joinToString()}")
                    }
                }


            } catch (e: Exception) {
                println("Login Error: ${e.message}")
                onLoginSuccess()
//                onLoginError("Failed")

            }
        }
    }
}
