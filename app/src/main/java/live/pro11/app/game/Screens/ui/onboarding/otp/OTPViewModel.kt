package live.pro11.app.game.Screens.ui.onboarding.otp
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import live.pro11.app.game.Screens.ui.onboarding.auth.service.OTPService
import live.pro11.app.game.base.BaseViewModel
import javax.inject.Inject

@HiltViewModel
class OTPViewModel @Inject constructor(
    private val otpService: OTPService
): BaseViewModel() {

    var otpValue by mutableStateOf("")

    fun verifyOTP() {

    }
}