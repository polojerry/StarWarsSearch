package com.polotech.starwars.navigation

import androidx.navigation.NavController
import com.polotech.starwars.navigation.NavigationDestination.*

class Navigator {
    lateinit var navController: NavController

    fun navigateToDestination(destination : NavigationDestination) = when (destination) {
        CharacterSearch -> {
            navController.navigate(NavigationMainDirections.actionGlobalSearchNavigation())
        }
        is CharacterDetails -> navController.navigate(NavigationMainDirections.actionGlobalDetailsNavigation(character = destination.character))
    }

}