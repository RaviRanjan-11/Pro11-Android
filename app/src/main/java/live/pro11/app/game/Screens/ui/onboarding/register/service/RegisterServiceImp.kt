package live.pro11.app.game.Screens.ui.onboarding.register.service

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import live.pro11.app.game.Screens.ui.onboarding.auth.service.RegisterService
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RegisterServiceImp {
    @Provides
    @Singleton
    fun provideOtpService(retrofit: Retrofit): RegisterService {
        return retrofit.create(RegisterService::class.java)
    }
}
