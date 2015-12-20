package com.zerobasedindex.github.mock;

import android.util.Log;

import com.zerobasedindex.github.data.GithubAPI;

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

}
