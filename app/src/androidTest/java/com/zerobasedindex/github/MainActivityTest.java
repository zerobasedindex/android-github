package com.zerobasedindex.github;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zerobasedindex.github.ui.MainActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

/**
 * Copyright 2015 Cody Henthorne
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void today() {

        onView(withId(R.id.recyclerView))
                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText("Test Repo 99"))))
                .check(matches(hasDescendant(allOf(isEnabled(), withText("Test Repo 99")))))
                .check(matches(hasDescendant(allOf(isEnabled(), withText("This is my desc.")))));


//        onView(withId(R.id.recyclerView))
//                .perform(RecyclerViewActions.scrollTo(withText("Test Repo 99")))
//                .check(matches(hasDescendant(allOf(not(isEnabled()), withText("Test Repo 99")))));
    }



}
