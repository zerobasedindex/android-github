package com.zerobasedindex.github;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.zerobasedindex.github.ui.RepoDetailsActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Copyright 2015 Cody Henthorne
 */
@RunWith(AndroidJUnit4.class)
public class RepoDetailsActivityTest {

    @Rule
    public ActivityTestRule<RepoDetailsActivity> activityRule = new ActivityTestRule<>(RepoDetailsActivity.class, true, false);

    @Test
    public void loadsWithIntent() {
        Intent intent = new Intent();
        intent.putExtra(RepoDetailsActivity.REPO_ID_EXTRA, (long) 0);
        activityRule.launchActivity(intent);

        assertEquals(activityRule.getActivity().getTitle(), "Test Repo 0");

//        Log.e("CODY", onView(withId(R.id.toolbar)));

//        onView(withId(R.id.toolbar))
//                .check(matches(hasDescendant(withText("Test Repo 0"))));

//        onView(withId(R.id.recyclerView))
//                .perform(RecyclerViewActions.scrollTo(hasDescendant(withText("Test Repo 99"))))
//                .check(matches(hasDescendant(allOf(isEnabled(), withText("Test Repo 99")))))
//                .check(matches(hasDescendant(allOf(isEnabled(), withText("This is my desc.")))));


//        onView(withId(R.id.recyclerView))
//                .perform(RecyclerViewActions.scrollTo(withText("Test Repo 99")))
//                .check(matches(hasDescendant(allOf(not(isEnabled()), withText("Test Repo 99")))));
    }



}
