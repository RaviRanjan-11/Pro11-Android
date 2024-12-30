package live.pro11.app.game.Screens.ui.Onboarding.login.model

data class LoginResponseModel(
    val loginData: LoginData,
    val error: List<String>,
    val message: String?,
    val statusCode: Int,
    val success: Boolean
)

data class LoginData(
    val `data`: String,
    val token: String
)