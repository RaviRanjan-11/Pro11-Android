package live.pro11.app.game.Screens.ui.onboarding.login

import android.util.Log
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

    var loginToken by mutableStateOf("")
        private  set

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
            showLoader()  // Show loader before API call
            try {
                val response = loginService.login(LoginRequest(email))

                if (response.success) {
                    println("Login Successful: $response")
                    loginToken = response.responseDTO.token
                    Log.d("Token", "Login Token: $loginToken")
                    println("Login Successful: $loginToken, ${response.responseDTO}")
                    onLoginSuccess()
                } else {
                    val errorMessage = when (response.statusCode) {
                        500 -> "Internal Server Error: ${response.message}"
                        else -> "Error: ${response.error.joinToString()}"
                    }
                    onLoginError(errorMessage)
                }
            } catch (e: Exception) {
                Log.e("Login Error", "Exception occurred: ${e.message}", e)
                onLoginError("An unexpected error occurred: ${e.message}")
            } finally {
                hideLoader()  // Hide loader after API call completes
            }
        }
    }
}
