package com.example.newanywhere

import android.os.Bundle
import androidx.appcompat.app.ActionBar
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.newanywhere.databinding.ActivityMainBinding
import com.example.newanywhere.ui.home.HomeFragment
import com.example.newanywhere.ui.map.MapFragment
import com.example.newanywhere.ui.search.SearchFragment
import com.example.newanywhere.ui.user.UserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val fragmentManager = supportFragmentManager
    private var homeFragment: HomeFragment? = null
    private var listFragment: ListFragment? = null
    private var mapFragment: MapFragment? = null
    private var searchFragment: SearchFragment? = null
    private var userFragment: UserFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val actionBar=  supportActionBar
        actionBar!!.hide()


        initBottomNav()

//        val navView: BottomNavigationView = binding.navView
//
//        val navController = findNavController(R.id.nav_host_fragment_activity_main)
//        // Passing each menu ID as a set of Ids because each
//        // menu should be considered as top level destinations.
//        val appBarConfiguration = AppBarConfiguration(
//            setOf(
//                R.id.navigation_home, R.id.navigation_list, R.id.navigation_map, R.id.navigation_search,R.id.navigation_user
//            )
//        )
////        setupActionBarWithNavController(navController, appBarConfiguration)
//        navView.setupWithNavController(navController)
    }

    private fun initBottomNav() {

        homeFragment= HomeFragment()
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main,homeFragment!!).commit()

        binding.navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home->{
                    if(homeFragment==null){
                        homeFragment=HomeFragment()
                        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_activity_main,homeFragment!!).commit()
                    }
                    else if(homeFragment!=null) fragmentManager.beginTransaction().show(homeFragment!!).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_list->{

                    return@setOnItemSelectedListener true
                }
                R.id.navigation_map->{
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_search->{
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_user->{

                    return@setOnItemSelectedListener true
                }
                else ->{
                    return@setOnItemSelectedListener true
                }
            }
        }

    }
}