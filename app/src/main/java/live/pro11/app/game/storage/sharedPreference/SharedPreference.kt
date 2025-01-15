package live.pro11.app.game.storage.sharedPreference

import android.content.Context
import android.content.SharedPreferences
import dagger.Provides


object SharedPrefsManager {

    private const val PREF_NAME = "MyPrefs"
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor

    // Initialize the SharedPrefsManager with context
    fun init(context: Context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
    }

    // Save methods
    fun saveString(key: String, value: String) {
        editor.putString(key, value)
        editor.apply()
    }

    fun saveInt(key: String, value: Int) {
        editor.putInt(key, value)
        editor.apply()
    }

    fun saveBoolean(key: String, value: Boolean) {
        editor.putBoolean(key, value)
        editor.apply()
    }

    // Retrieve methods
    fun getString(key: String, defaultValue: String = ""): String {
        return sharedPreferences.getString(key, defaultValue) ?: defaultValue
    }

    fun getInt(key: String, defaultValue: Int = 0): Int {
        return sharedPreferences.getInt(key, defaultValue)
    }

    fun getBoolean(key: String, defaultValue: Boolean = false): Boolean {
        return sharedPreferences.getBoolean(key, defaultValue)
    }

    // Clear all preferences
    fun clearAllData() {
        editor.clear()
        editor.apply()
    }

    // Remove a specific key-value pair
    fun removeData(key: String) {
        editor.remove(key)
        editor.apply()
    }
}
