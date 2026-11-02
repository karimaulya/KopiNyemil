package lat.pam.kopinyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class ProfileFragment : Fragment(R.layout.fragment_profile) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val session = SessionManager(requireContext())
        val tvUsernameBadge = view.findViewById<TextView>(R.id.tvProfileUsername)
        val etName = view.findViewById<EditText>(R.id.etProfileName)
        val etUsername = view.findViewById<EditText>(R.id.etProfileUsername)

        tvUsernameBadge.text = session.username.ifBlank { "user" }
        etName.setText(session.fullName)
        etUsername.setText(session.username)

        view.findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            val newName = etName.text.toString().trim()
            val newUsername = etUsername.text.toString().trim()

            when {
                newName.isEmpty() -> {
                    Toast.makeText(requireContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
                newUsername.isEmpty() -> {
                    Toast.makeText(requireContext(), "Username tidak boleh kosong", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    session.fullName = newName
                    session.username = newUsername
                    tvUsernameBadge.text = newUsername
                    Toast.makeText(requireContext(), "Profile berhasil disimpan", Toast.LENGTH_SHORT).show()
                }
            }
        }

        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            val intent = Intent(requireContext(), SignUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
