package live.pro11.app.game.Screens.ui.onboarding.register.dto

data class ReferralCode(
    val id: Int,
    val code: String,
    val createdAt: String
)

data class Wallet(
    val id: Int,
    val currentBalance: Int,
    val createdAt: String,
    val updatedAt: String
)

data class User(
    val id: Int,
    val userName: String,
    val emailId: String,
    val phone: String,
    val otp: String?,
    val roles: String,
    val otpExpirationTime: String?,
    val createdAt: String,
    val updatedAt: String,
    val deletedAt: String?,
    val referralCode: ReferralCode?,
    val wallet: Wallet?,
    val referralUsages: String?,
    val acceptedTermsAndConditions: Boolean
)
