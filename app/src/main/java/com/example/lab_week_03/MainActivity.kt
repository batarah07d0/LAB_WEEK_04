package com.example.lab_week_03
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment)
                as NavHostFragment
        val navController = navHostFragment.navController
        //Creating top level destinations
        //and adding them to the draw
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listFragment, R.id.favoritesFragment, R.id.cafeFragment
            ), findViewById(R.id.drawer_layout)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<NavigationView>(R.id.nav_view)
            ?.setupWithNavController(navController)

        findViewById<BottomNavigationView>(R.id.bottom_nav)
            ?.setupWithNavController(navController)

//        val viewPager = findViewById<ViewPager2>(R.id.view_pager)
//        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
//        val adapter = CafeAdapter(supportFragmentManager, lifecycle)
//        viewPager.adapter = adapter
//        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
//            tab.text = resources.getString(TABS_FIXED[position])
//        }.attach()
    }
    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}