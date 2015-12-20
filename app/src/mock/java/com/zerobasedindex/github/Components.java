package com.zerobasedindex.github;

import android.util.Log;

import com.zerobasedindex.github.data.GithubComponent;
import com.zerobasedindex.github.data.GithubModule;
import com.zerobasedindex.github.mock.MockGithubModule;
import com.zerobasedindex.github.network.NetworkModule;

/**
 * Copyright 2015 Cody Henthorne
 */
public class Components {

    public static GithubComponent buildGithubComponent() {
        Log.e("CODY", "called mock buildghc");
        return com.zerobasedindex.github.mock.DaggerMockGithubComponent.builder()
                .mockGithubModule(new MockGithubModule())
                .build();
    }

}
