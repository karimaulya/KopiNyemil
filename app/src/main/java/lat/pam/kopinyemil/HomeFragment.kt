package lat.pam.kopinyemil

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeFragment : Fragment(R.layout.fragment_home) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val session = SessionManager(requireContext())
        view.findViewById<TextView>(R.id.tvGreeting).text = "Halo ${session.displayName()},"

        val rvMenu = view.findViewById<RecyclerView>(R.id.rvMenu)
        rvMenu.layoutManager = LinearLayoutManager(requireContext())
        rvMenu.adapter = MenuAdapter(menuList) { menu ->
            Toast.makeText(requireContext(), "${menu.name} - ${menu.price}", Toast.LENGTH_SHORT).show()
        }
    }
}
