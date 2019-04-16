package dimi.com.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.Navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import dimi.com.jetpack.ui.main.MessageListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        JetpackApp.appComponent.inject(this)

        val navController = findNavController(this, R.id.nav_host_fragment)
        setupActionBarWithNavController(this, navController)

//        if (savedInstanceState == null) {
//            supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment, MessageListFragment.newInstance())
//                .commitNow()
//        }

    }

    override fun onSupportNavigateUp() = findNavController(this, R.id.nav_host_fragment).navigateUp()
}
