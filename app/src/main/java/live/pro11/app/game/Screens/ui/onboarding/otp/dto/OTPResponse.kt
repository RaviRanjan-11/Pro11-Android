package live.pro11.app.game.Screens.ui.onboarding.otp.dto

data class OTPResponse(
    val responseData: Data,
    val message: String,
    val statusCode: Int,
    val success: Boolean
)