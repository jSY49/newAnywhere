package com.example.newanywhere

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.newanywhere.databinding.ActivityMainBinding
import com.example.newanywhere.ui.home.HomeFragment
import com.example.newanywhere.ui.list.ListFragment
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

        setFragment()
    }

    private fun setFragment() {
        homeFragment = HomeFragment()
        fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_activity_main, homeFragment!!).commit()

        binding.navView.setOnItemSelectedListener {
            when(it.itemId){
                R.id.navigation_home->{
                    if(homeFragment == null){
                        homeFragment = HomeFragment()
                        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_activity_main,homeFragment!!).commit()
                    }
                    if(homeFragment != null) fragmentManager.beginTransaction().show(homeFragment!!).commit()
                    if(listFragment != null) fragmentManager.beginTransaction().hide(listFragment!!).commit()
                    if(mapFragment != null) fragmentManager.beginTransaction().hide(mapFragment!!).commit()
                    if(searchFragment != null) fragmentManager.beginTransaction().hide(searchFragment!!).commit()
                    if(userFragment != null) fragmentManager.beginTransaction().hide(userFragment!!).commit()
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_list->{
                    if(listFragment == null){
                        listFragment = ListFragment()
                        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_activity_main,listFragment!!).commit()
                    }
                    if(homeFragment != null) fragmentManager.beginTransaction().hide(homeFragment!!).commit()
                    if(listFragment != null) fragmentManager.beginTransaction().show(listFragment!!).commit()
                    if(mapFragment != null) fragmentManager.beginTransaction().hide(mapFragment!!).commit()
                    if(searchFragment != null) fragmentManager.beginTransaction().hide(searchFragment!!).commit()
                    if(userFragment != null) fragmentManager.beginTransaction().hide(userFragment!!).commit()
                    return@setOnItemSelectedListener true
                }

                R.id.navigation_map->{
                    if(mapFragment == null){
                        mapFragment = MapFragment()
                        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_activity_main,mapFragment!!).commit()
                    }
                    if(homeFragment != null) fragmentManager.beginTransaction().hide(homeFragment!!).commit()
                    if(listFragment != null) fragmentManager.beginTransaction().hide(listFragment!!).commit()
                    if(mapFragment != null) fragmentManager.beginTransaction().show(mapFragment!!).commit()
                    if(searchFragment != null) fragmentManager.beginTransaction().hide(searchFragment!!).commit()
                    if(userFragment != null) fragmentManager.beginTransaction().hide(userFragment!!).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_search->{
                    if(searchFragment == null){
                        searchFragment = SearchFragment()
                        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_activity_main,searchFragment!!).commit()
                    }
                    if(homeFragment != null) fragmentManager.beginTransaction().hide(homeFragment!!).commit()
                    if(listFragment != null) fragmentManager.beginTransaction().hide(listFragment!!).commit()
                    if(mapFragment != null) fragmentManager.beginTransaction().hide(mapFragment!!).commit()
                    if(searchFragment != null) fragmentManager.beginTransaction().show(searchFragment!!).commit()
                    if(userFragment != null) fragmentManager.beginTransaction().hide(userFragment!!).commit()
                    return@setOnItemSelectedListener true
                }
                R.id.navigation_user->{
                    if(userFragment == null){
                        userFragment = UserFragment()
                        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_activity_main,userFragment!!).commit()
                    }
                    if(homeFragment != null) fragmentManager.beginTransaction().hide(homeFragment!!).commit()
                    if(listFragment != null) fragmentManager.beginTransaction().hide(listFragment!!).commit()
                    if(mapFragment != null) fragmentManager.beginTransaction().hide(mapFragment!!).commit()
                    if(searchFragment != null) fragmentManager.beginTransaction().hide(searchFragment!!).commit()
                    if(userFragment != null) fragmentManager.beginTransaction().show(userFragment!!).commit()
                    return@setOnItemSelectedListener true
                }

                else-> return@setOnItemSelectedListener true
            }
        }

    }

}