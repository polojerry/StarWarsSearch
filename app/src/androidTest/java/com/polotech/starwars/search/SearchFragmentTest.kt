package com.polotech.starwars.search

import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ActivityScenario.launch
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.polotech.starwars.data.remote.util.ErrorHandlerImpl
import com.polotech.starwars.domain.models.error.ErrorHandler
import com.polotech.starwars.domain.repository.CharacterDetailsRepository
import com.polotech.starwars.domain.repository.SearchCharacterRepository
import com.polotech.starwars.search.di.RemoteDataSource
import com.polotech.starwars.search.fake.DataFake.characters.characterPresenter
import com.polotech.starwars.search.fake.DataFake.planet.planetPresenter
import com.polotech.starwars.search.fake.DataFake.search.empty_search
import com.polotech.starwars.search.fake.DataFake.search.searchWithValues
import com.polotech.starwars.search.fake.DataFake.specie.speciePresenter
import com.polotech.starwars.search.fake.repository.CharacterDetailsRepositoryFake
import com.polotech.starwars.search.fake.repository.SearchCharacterRepositoryFake
import com.polotech.starwars.search.ui.MainActivity
import com.polotech.starwars.search.ui.search.SearchRecyclerAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(RemoteDataSource::class)
class SearchFragmentTest {

    private val exploreStarWars = "Lets explore the star wars Universe"
    private val emptySearch =  "Looks like there is no result"

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setUp() {
        launchActivity()
    }


    @Module
    @InstallIn(ActivityComponent::class)
    object TestRepo {
        @Provides
        fun providesSearchRepository(): SearchCharacterRepository =
            SearchCharacterRepositoryFake()

        @Provides
        fun providesCharacterDetailsRepository(): CharacterDetailsRepository =
            CharacterDetailsRepositoryFake()

        @Provides
        fun providesErrorHandler(): ErrorHandler = ErrorHandlerImpl()

    }


    @Test
    fun when_apps_launchedSearchExploreImageIllustrationShouldBeDisplayed() {
        onView(withId(R.id.text_search_illustration))
            .check(matches(withText(exploreStarWars)))

    }

    @Test
    fun when_search_result_is_EmptyIllustrationEmptyIsDisplayed() {

        onView(withId(R.id.text_search))
            .perform(typeText(empty_search), closeSoftKeyboard())


        onView(withId(R.id.text_search_illustration))
            .check(matches(withText(emptySearch)))

    }

    @Test
    fun when_search_item_is_clickedNavigateToDetailsScreen() {
        onView(withId(R.id.text_search))
            .perform(typeText(searchWithValues), closeSoftKeyboard())


        onView(withId(R.id.recycler_view_search))
            .perform(RecyclerViewActions.actionOnItemAtPosition<SearchRecyclerAdapter.SearchViewHolder>(
                0,
                click()))

        onView(withId(R.id.layout_character_details))
            .check(matches(isDisplayed()))
    }

    @Test
    fun when_navigate_to_detailsSelectedCharacterDetailsShouldBeDisplayed() {
        onView(withId(R.id.text_search))
            .perform(typeText(searchWithValues), closeSoftKeyboard())


        onView(withId(R.id.recycler_view_search))
            .perform(RecyclerViewActions.actionOnItemAtPosition<SearchRecyclerAdapter.SearchViewHolder>(
                0,
                click()))


        onView(withId(R.id.text_birth_year))
            .check(matches(withText(characterPresenter.birthYear)))

        onView(withId(R.id.text_specie_name))
            .check(matches(withText(speciePresenter.name)))

        onView(withId(R.id.text_planet_name))
            .check(matches(withText(planetPresenter.name)))

    }


    private fun launchActivity(): ActivityScenario<MainActivity>? {
        return launch(MainActivity::class.java)
    }


}