package live.pro11.app.game.Screens.ui.onboarding.otp.dto

data class OTPResponse(
    val access_token: String,
    val access_token_expiry: Int,
    val token_type: String,
    val user_name: UserName
)
data class UserName(
    val email: String,
    val phoneNo: Any?,
    val role: String,
    val userId: Int,
    val username: String
)