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
        val tvGreeting = view.findViewById<TextView>(R.id.tvProfileGreeting)
        val etName = view.findViewById<EditText>(R.id.etProfileName)

        tvGreeting.text = "Halo ${session.displayName()},"
        etName.setText(session.fullName)

        view.findViewById<Button>(R.id.btnSaveProfile).setOnClickListener {
            val newName = etName.text.toString().trim()
            if (newName.isEmpty()) {
                Toast.makeText(requireContext(), "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            session.fullName = newName
            tvGreeting.text = "Halo ${session.displayName()},"
            Toast.makeText(requireContext(), "Profile disimpan", Toast.LENGTH_SHORT).show()
        }

        view.findViewById<Button>(R.id.btnLogout).setOnClickListener {
            val intent = Intent(requireContext(), SignUpActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }
}
