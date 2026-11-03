package lat.pam.kopinyemil

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var btnFloatingCart: View
    private lateinit var tvCartBadge: TextView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val session = SessionManager(requireContext())
        view.findViewById<TextView>(R.id.tvGreeting).text = "Hi, ${session.displayName()}"

        btnFloatingCart = view.findViewById(R.id.btnFloatingCart)
        tvCartBadge = view.findViewById(R.id.tvCartBadge)

        val rvMenu = view.findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(requireContext())
        val adapter = MenuAdapter(menuList) { menu ->
            CartManager.addItem(menu)
        }
        rvMenu.adapter = adapter

        btnFloatingCart.setOnClickListener {
            (activity as? HomeActivity)?.openOrderTab()
        }

        CartManager.onCartUpdatedListener = {
            updateCartFloatingButton()
        }

        updateCartFloatingButton()
    }

    override fun onResume() {
        super.onResume()
        updateCartFloatingButton()
    }

    override fun onDestroyView() {
        CartManager.onCartUpdatedListener = null
        super.onDestroyView()
    }

    private fun updateCartFloatingButton() {
        val totalCount = CartManager.getTotalCount()

        if (totalCount > 0) {
            btnFloatingCart.visibility = View.VISIBLE
            tvCartBadge.text = "$totalCount Items"
        } else {
            btnFloatingCart.visibility = View.GONE
        }
    }
}
