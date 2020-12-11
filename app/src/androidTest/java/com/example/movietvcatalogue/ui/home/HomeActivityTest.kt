package com.example.movietvcatalogue.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.movietvcatalogue.R
import com.example.movietvcatalogue.utils.FormatedMethod
import com.example.movietvcatalogue.utils.MoviesDataDummy
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class HomeActivityTest {

    private val dummyMovies = MoviesDataDummy.generateDummyMovies()
    private val dummyTvShows = MoviesDataDummy.generateDummyTvShows()

    @Before
    fun setup() {
        ActivityScenario.launch(HomeActivity::class.java)
    }

    @Test
    fun loadMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyMovies.size
            )
        )
    }

    @Test
    fun loadTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_show))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size
            )
        )
    }

    @Test
    fun loadDetailMovies() {
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_creator)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_creator_title)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_type)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_type_title)).check(matches(withEffectiveVisibility(Visibility.GONE)))

        onView(withId(R.id.tv_title)).check(matches(withText("${dummyMovies[0].title} (${dummyMovies[0].year})")))
        onView(withId(R.id.tv_daterelease)).check(
            matches(
                withText(
                    FormatedMethod.getDateRilease(
                        dummyMovies[0].dateRelease
                    )
                )
            )
        )
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyMovies[0].genre)))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyMovies[0].description)))
        onView(withId(R.id.tv_director)).check(matches(withText(dummyMovies[0].director)))
        onView(withId(R.id.tv_status)).check(matches(withText(dummyMovies[0].status)))
        onView(withId(R.id.tv_language)).check(matches(withText(dummyMovies[0].language)))
        onView(withId(R.id.tv_budget)).check(
            matches(
                withText(
                    FormatedMethod.roundOffDecimal(
                        dummyMovies[0].budget
                    )
                )
            )
        )
        onView(withId(R.id.tv_revenue)).check(
            matches(
                withText(
                    FormatedMethod.roundOffDecimal(
                        dummyMovies[0].revenue
                    )
                )
            )
        )
    }

    @Test
    fun loadDetailTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_show))
            .check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                ViewActions.click()
            )
        )
        onView(withId(R.id.tv_title)).check(matches(isDisplayed()))

        onView(withId(R.id.tv_daterelease)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_daterelease_title)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_director)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_director_title)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_budget)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_budget_title)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_revenue)).check(matches(withEffectiveVisibility(Visibility.GONE)))
        onView(withId(R.id.tv_revenue_title)).check(matches(withEffectiveVisibility(Visibility.GONE)))

        onView(withId(R.id.tv_title)).check(matches(withText("${dummyTvShows[0].title} (${dummyTvShows[0].year})")))
        onView(withId(R.id.tv_genre)).check(matches(withText(dummyTvShows[0].genre)))
        onView(withId(R.id.tv_description)).check(matches(withText(dummyTvShows[0].description)))
        onView(withId(R.id.tv_creator)).check(matches(withText(dummyTvShows[0].creator)))
        onView(withId(R.id.tv_type)).check(matches(withText(dummyTvShows[0].type)))
        onView(withId(R.id.tv_status)).check(matches(withText(dummyTvShows[0].status)))
        onView(withId(R.id.tv_language)).check(matches(withText(dummyTvShows[0].language)))
    }

    @Test
    fun buttonShareMovies() {
        onView(withId(R.id.rv_movies)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_movies)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                dummyMovies.size - 8,
                ViewActions.click()
            )
        )
        onView(withId(R.id.fab)).perform(click())
    }

    @Test
    fun buttonShareTvShows() {
        onView(withText("TV Shows")).perform(click())
        onView(withId(R.id.rv_tv_show)).check(matches(isDisplayed()))
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                dummyTvShows.size - 3,
                ViewActions.click()
            )
        )
        onView(withId(R.id.fab)).perform(click())
    }

}