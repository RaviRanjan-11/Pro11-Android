package live.pro11.app.game.Screens.ui.onboarding.otp.dto

data class Data(
    val access_token: String,
    val access_token_expiry: Int,
    val token_type: String,
    val user_name: UserName
)