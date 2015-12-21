package com.zerobasedindex.github.mock;

import com.zerobasedindex.github.model.Commit;
import com.zerobasedindex.github.model.FullCommit;
import com.zerobasedindex.github.model.Owner;
import com.zerobasedindex.github.model.Repo;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2015 Cody Henthorne
 */
public class MockGithubData {

    public static final List<Repo> REPOS;
    public static final List<FullCommit> COMMITS;

    static {
        REPOS = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            REPOS.add(new Repo(i, "Test Repo " + i, "This is my desc.", new Owner("TestOwner", "mock:///repo/two.png")));
        }

        COMMITS = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            COMMITS.add(new FullCommit("SHA"+i, new Commit("This is my message")));
        }
    }

}
