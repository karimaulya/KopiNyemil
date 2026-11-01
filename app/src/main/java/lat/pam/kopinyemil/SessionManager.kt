package lat.pam.kopinyemil

import android.content.Context
import androidx.core.content.edit

class SessionManager(context: Context) {

    private val prefs = context.applicationContext
        .getSharedPreferences("kopi_nyemil_prefs", Context.MODE_PRIVATE)

    fun register(name: String, username: String, password: String) {
        prefs.edit {
            putString(KEY_NAME, name)
                .putString(KEY_USERNAME, username)
                .putString(KEY_PASSWORD, password)
        }
    }

    fun hasAccount(): Boolean = prefs.contains(KEY_USERNAME)

    fun login(username: String, password: String): Boolean {
        return prefs.getString(KEY_USERNAME, null) == username &&
                prefs.getString(KEY_PASSWORD, null) == password
    }

    var fullName: String
        get() = prefs.getString(KEY_NAME, "") ?: ""
        set(value) {
            prefs.edit { putString(KEY_NAME, value) }
        }

    /** Nama yang tampil di "Halo ..." */
    fun displayName(): String = fullName.ifBlank { "Teman" }

    companion object {
        private const val KEY_NAME = "name"
        private const val KEY_USERNAME = "username"
        private const val KEY_PASSWORD = "password"
    }
}
