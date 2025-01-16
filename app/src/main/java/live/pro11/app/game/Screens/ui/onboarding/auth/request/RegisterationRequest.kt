package live.pro11.app.game.Screens.ui.onboarding.auth.request

data class RegisterationRequest(
    val username: String,
    val email: String,
    val phoneNo: String,
    val acceptedTermsAndConditions: Boolean,
    val referralCode: String?
)
