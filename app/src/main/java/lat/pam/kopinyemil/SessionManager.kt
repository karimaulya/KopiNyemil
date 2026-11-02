package lat.pam.kopinyemil

import android.content.Context
import androidx.core.content.edit

class SessionManager(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences("kopi_nyemil_prefs", Context.MODE_PRIVATE)

    fun register(name: String, username: String, password: String) {
        prefs.edit {
            putString(KEY_NAME, name.trim())
                .putString(KEY_USERNAME, username.trim())
                .putString(KEY_PASSWORD, password.trim())
        }
    }

    fun hasAccount(): Boolean = prefs.contains(KEY_USERNAME)

    fun login(username: String, password: String): Boolean {
        val savedUsername = prefs.getString(KEY_USERNAME, null)
        val savedPassword = prefs.getString(KEY_PASSWORD, null)

        // Jika belum ada akun tersimpan, berikan fallback demo account (admin / 123456)
        if (savedUsername == null || savedPassword == null) {
            if (username.trim().equals("admin", ignoreCase = true) && password.trim() == "123456") {
                register("Admin", "admin", "123456")
                return true
            }
            return false
        }

        return savedUsername.equals(username.trim(), ignoreCase = true) &&
                savedPassword == password.trim()
    }

    var fullName: String
        get() = prefs.getString(KEY_NAME, "") ?: ""
        set(value) {
            prefs.edit { putString(KEY_NAME, value) }
        }

    var username: String
        get() = prefs.getString(KEY_USERNAME, "") ?: ""
        set(value) {
            prefs.edit { putString(KEY_USERNAME, value) }
        }

    /** Nama yang tampil di "Halo ..." */
    fun displayName(): String = fullName.ifBlank { "Teman" }

    companion object {
        private const val KEY_NAME = "name"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
    }
}
