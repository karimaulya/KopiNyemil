package lat.pam.kopinyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment

class OrderFragment : Fragment(R.layout.fragment_order) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etName = view.findViewById<EditText>(R.id.etOrderName)
        val etAddress = view.findViewById<EditText>(R.id.etOrderAddress)
        val etDetail = view.findViewById<EditText>(R.id.etOrderDetail)

        // isi otomatis nama dari akun
        etName.setText(SessionManager(requireContext()).fullName)

        view.findViewById<Button>(R.id.btnOrder).setOnClickListener {
            val name = etName.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val detail = etDetail.text.toString().trim()

            if (name.isEmpty() || address.isEmpty() || detail.isEmpty()) {
                Toast.makeText(requireContext(), "Lengkapi semua data pengiriman", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            startActivity(Intent(requireContext(), ConfirmationActivity::class.java))
        }
    }
}
