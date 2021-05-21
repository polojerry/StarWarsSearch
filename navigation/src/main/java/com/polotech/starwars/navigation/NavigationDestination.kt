package com.polotech.starwars.navigation

sealed class NavigationDestination {

    object CharacterSearch : NavigationDestination()

    class CharacterDetails(val character : String) : NavigationDestination()
}