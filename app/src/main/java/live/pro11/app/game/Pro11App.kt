package live.pro11.app.game

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import live.pro11.app.game.storage.sharedPreference.SharedPrefsManager

@HiltAndroidApp
class Pro11App : Application() {
    override fun onCreate() {
        super.onCreate()
        SharedPrefsManager.init(this) // Initialize here
    }
}
