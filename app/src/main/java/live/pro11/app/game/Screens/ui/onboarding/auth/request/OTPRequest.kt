package live.pro11.app.game.Screens.ui.onboarding.auth.request

data class OTPRequest(
    val otp: String,
    val token: String,
    val username: String
)