package com.catata.perenxisainfo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.catata.perenxisainfo.databinding.ActivityMainBinding
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Thread.sleep(2000)

        setTheme(R.style.Theme_PerenxisaInfo)

        setContentView(ActivityMainBinding.inflate(layoutInflater).also { binding = it }
            .root)

        setSupportActionBar(binding.toolbar)

        val drawerLayout: DrawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        val navHosFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHosFragment.navController

        appBarConfiguration = AppBarConfiguration(setOf(
            //Top-level destinations
            R.id.tabbed1Fragment,
            R.id.homeFragment,
            R.id.mapsFragment2

            ),
            drawerLayout
        )


        NavigationUI.setupWithNavController(navView, navController)
        NavigationUI.setupWithNavController(binding.toolbar, navController, appBarConfiguration)

        /*navView.setNavigationItemSelectedListener { item ->
            var transaction = supportFragmentManager.beginTransaction()
            when(item.itemId){
                R.id.homeFragment->{
                    transaction.replace(R.id.nav_host_fragment,Tabbed1Fragment())
                }

                R.id.mapsFragment->{
                    transaction.replace(R.id.nav_host_fragment,MapsFragment())
                }
                else ->{
                    transaction.replace(R.id.nav_host_fragment,Tabbed1Fragment())
                }
            }

            transaction.addToBackStack(null)
            transaction.commit()

            navView.menu.close()


            return@setNavigationItemSelectedListener true
        }*/


    }
}