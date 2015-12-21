package com.zerobasedindex.github;

import android.app.Application;

import com.zerobasedindex.github.data.GithubComponent;
import com.zerobasedindex.github.mock.MockGithubModule;
import com.zerobasedindex.github.mock.MockNetworkModule;

/**
 * Copyright 2015 Cody Henthorne
 */
public class Components {

    public static GithubComponent buildGithubComponent(Application app) {
        return com.zerobasedindex.github.mock.DaggerMockGithubComponent.builder()
                .appModule(new AppModule(app))
                .mockNetworkModule(new MockNetworkModule("mock://"))
                .mockGithubModule(new MockGithubModule())
                .build();
    }

}
