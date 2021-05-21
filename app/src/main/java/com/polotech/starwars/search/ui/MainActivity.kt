package com.polotech.starwars.search.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.polotech.starwars.navigation.Navigation
import com.polotech.starwars.navigation.NavigationDestination
import com.polotech.starwars.navigation.Navigator
import com.polotech.starwars.search.R
import com.polotech.starwars.search.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), Navigation {
    private val navigator : Navigator = Navigator()
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_StarWarsSearch)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navController = supportFragmentManager.findFragmentById(R.id.nav_host_main)?.findNavController()
        if (navController != null) {
            navigator.navController = navController
        }

        navigateToStart()
    }

    private fun navigateToStart() {
        navigator.navigateToDestination(NavigationDestination.CharacterSearch)
    }

    override fun toNavigationDestination(destination: NavigationDestination) {
        navigator.navigateToDestination(destination)
    }
}