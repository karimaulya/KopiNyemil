package lat.pam.kopinyemil

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment

/** Host untuk 3 fragment: Home, Order, Profile. */
class HomeActivity : AppCompatActivity() {

    private lateinit var btnHome: Button
    private lateinit var btnOrder: Button
    private lateinit var btnProfile: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)

        btnHome = findViewById(R.id.btnNavHome)
        btnOrder = findViewById(R.id.btnNavOrder)
        btnProfile = findViewById(R.id.btnNavProfile)

        btnHome.setOnClickListener { showFragment(HomeFragment(), btnHome) }
        btnOrder.setOnClickListener { showFragment(OrderFragment(), btnOrder) }
        btnProfile.setOnClickListener { showFragment(ProfileFragment(), btnProfile) }

        if (savedInstanceState == null) {
            showFragment(HomeFragment(), btnHome)
        } else {
            // setelah rotasi: fragment dipulihkan sistem, tinggal tandai tab aktif
            val current = supportFragmentManager.findFragmentById(R.id.fragmentContainer)
            setActiveTab(
                when (current) {
                    is OrderFragment -> btnOrder
                    is ProfileFragment -> btnProfile
                    else -> btnHome
                }
            )
        }
    }

    private fun showFragment(fragment: Fragment, activeButton: Button) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, fragment)
            .commit()
        setActiveTab(activeButton)
    }

    private fun setActiveTab(active: Button) {
        listOf(btnHome, btnOrder, btnProfile).forEach { btn ->
            if (btn == active) {
                btn.setBackgroundResource(R.drawable.bg_btn_kuning)
            } else {
                btn.setBackgroundResource(R.drawable.bg_nav_off)
            }
        }
    }
}
