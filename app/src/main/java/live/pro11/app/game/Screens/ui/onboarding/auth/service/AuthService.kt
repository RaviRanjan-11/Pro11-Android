package live.pro11.app.game.Screens.ui.onboarding.auth.service

import live.pro11.app.game.Screens.ui.onboarding.auth.request.LoginRequest
import live.pro11.app.game.Screens.ui.onboarding.auth.request.OTPRequest
import live.pro11.app.game.Screens.ui.onboarding.login.model.LoginResponse
import live.pro11.app.game.Screens.ui.onboarding.otp.dto.OTPResponse
import live.pro11.app.game.base.BaseDTO
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginService {
    @POST("/auth/otp")
    suspend fun login(
        @Body requestBody: LoginRequest
    ): BaseDTO<LoginResponse>
}

interface  OTPService {
    @POST("/auth/sign-in")
    suspend fun verifyOTP(
        @Body requestBody: OTPRequest
    ):BaseDTO<OTPResponse>
}
