package com.espresso.learning

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest{

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_navSecondaryActivity() {
        onView(withId(R.id.main)).check(matches(isDisplayed()))
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
    }

    /**
     * Test both ways to navigate from SecondaryActivity to MainActivity
     */
    @Test
    fun test_backPress_toMainActivity() {
        onView(withId(R.id.button_next_activity)).perform(click())
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))
        onView(withId(R.id.button_back)).perform(click()) // method 1
        onView(withId(R.id.main)).check(matches(isDisplayed()))

        onView(withId(R.id.button_next_activity)).perform(click())
        Espresso.pressBack() // method 2
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}
















