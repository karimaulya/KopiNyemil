package lat.pam.kopinyemil

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class OrderFragment : Fragment(R.layout.fragment_order) {

    private lateinit var tvOrderItemsPreview: TextView
    private lateinit var tvOrderTotalPrice: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val etName = view.findViewById<EditText>(R.id.etOrderName)
        val etAddress = view.findViewById<EditText>(R.id.etOrderAddress)
        val etDetail = view.findViewById<EditText>(R.id.etOrderDetail)
        tvOrderItemsPreview = view.findViewById(R.id.tvOrderItemsPreview)
        tvOrderTotalPrice = view.findViewById(R.id.tvOrderTotalPrice)

        // isi otomatis nama dari akun
        etName.setText(SessionManager(requireContext()).fullName)

        updatePreview()

        view.findViewById<Button>(R.id.btnOrder).setOnClickListener {
            val name = etName.text.toString().trim()
            val address = etAddress.text.toString().trim()
            val detail = etDetail.text.toString().trim()

            if (CartManager.getTotalCount() == 0) {
                Toast.makeText(requireContext(), "Pilih setidaknya 1 menu terlebih dahulu!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (name.isEmpty() || address.isEmpty() || detail.isEmpty()) {
                Toast.makeText(requireContext(), "Lengkapi semua data pengiriman", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            CartManager.clear()
            startActivity(Intent(requireContext(), ConfirmationActivity::class.java))
        }
    }

    override fun onResume() {
        super.onResume()
        updatePreview()
    }

    private fun updatePreview() {
        val cartItems = CartManager.getCartItems()
        if (cartItems.isEmpty()) {
            tvOrderItemsPreview.text = "Belum ada menu yang dipilih. Silakan pilih menu di Home dulu!"
            tvOrderTotalPrice.text = "Total: Rp0"
        } else {
            val sb = StringBuilder()
            for ((item, qty) in cartItems) {
                sb.append("• ").append(qty).append("x ").append(item.name).append("\n")
            }
            tvOrderItemsPreview.text = sb.toString().trimEnd()
            tvOrderTotalPrice.text = "Total: " + CartManager.formatRupiah(CartManager.getTotalPrice())
        }
    }
}
