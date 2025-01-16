package live.pro11.app.game.Screens.ui.onboarding.login.model

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("data") val email: String,
    val token: String
)
