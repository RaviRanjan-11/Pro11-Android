package live.pro11.app.game.Screens.ui.onboarding.otp.service
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import live.pro11.app.game.Screens.ui.onboarding.auth.service.OTPService
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object OTPServiceImp {

    @Provides
    @Singleton
    fun provideOtpService(retrofit: Retrofit): OTPService {
        return retrofit.create(OTPService::class.java)
    }

}
