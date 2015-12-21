package com.zerobasedindex.github;

import android.app.Application;

import com.zerobasedindex.github.data.GithubComponent;
import com.zerobasedindex.github.data.GithubModule;
import com.zerobasedindex.github.network.NetworkModule;

/**
 * Copyright 2015 Cody Henthorne
 */
public class Components {

    public static GithubComponent buildGithubComponent(Application app) {
        return com.zerobasedindex.github.data.DaggerGithubComponent.builder()
                .appModule(new AppModule(app))
                .networkModule(new NetworkModule("https://api.github.com"))
                .githubModule(new GithubModule())
                .build();
    }

}
