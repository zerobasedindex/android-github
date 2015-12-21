package com.zerobasedindex.github.mock;

import com.zerobasedindex.github.data.GithubAPI;
import com.zerobasedindex.github.data.GithubDM;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Copyright 2015 Cody Henthorne
 */
@Module
public class MockGithubModule {

    @Singleton
    @Provides
    public GithubAPI provideGithubAPI() {
        return new MockGithubAPI();
    }

    @Singleton
    @Provides
    public GithubDM provideGithubDM(GithubAPI githubAPI) {
        return new MockGithubDM(githubAPI);
    }

}
