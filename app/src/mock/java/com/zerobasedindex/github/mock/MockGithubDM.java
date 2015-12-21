package com.zerobasedindex.github.mock;

import com.zerobasedindex.github.data.GithubAPI;
import com.zerobasedindex.github.data.GithubDM;
import com.zerobasedindex.github.model.Repo;

/**
 * Copyright 2015 Cody Henthorne
 */
public class MockGithubDM extends GithubDM {

    public MockGithubDM(GithubAPI githubAPI) {
        super(githubAPI);
    }

    public Repo getRepo(long repoId) {
        return MockGithubData.REPOS.get((int)repoId);
    }
}
