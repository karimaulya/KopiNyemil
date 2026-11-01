package lat.pam.kopinyemil

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        val session = SessionManager(this)
        val etUsername = findViewById<EditText>(R.id.etLoginUsername)
        val etPassword = findViewById<EditText>(R.id.etLoginPassword)

        findViewById<Button>(R.id.btnLoginSubmit).setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString()

            when {
                username.isEmpty() || password.isEmpty() ->
                    toast("Username dan password wajib diisi")
                !session.hasAccount() ->
                    toast("Belum ada akun, silakan register dulu")
                session.login(username, password) -> {
                    val intent = Intent(this, HomeActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                }
                else -> toast("Username atau password salah")
            }
        }
    }

    private fun toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}
