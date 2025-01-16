package live.pro11.app.game.Screens.ui.onboarding.register

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
    var email by   mutableStateOf("")
    var name by  mutableStateOf("")
    var mobile by   mutableStateOf("")
    var referralCode by   mutableStateOf("")
    var isChecked by   mutableStateOf(false)
    var isButtonEnabled by   mutableStateOf(false)

    fun registerUser(
        onRegisterSuccess: () -> Unit,
        onRegisterError: (String) -> Unit
    ) {
        viewModelScope.launch {
            showLoader()
            try {
                val response = registerService.registerWithoutReferal(
                    RegisterationRequest(
                        userName = email,
                        phoneNo = mobile,
                        email = email,
                        acceptedTermsAndConditions = isChecked,
                        referralCode = referralCode )
                )

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
