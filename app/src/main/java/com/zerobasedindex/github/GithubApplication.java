package com.zerobasedindex.github;

import android.app.Application;

import com.zerobasedindex.github.data.GithubComponent;

public class GithubApplication extends Application {

    private GithubComponent githubComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        githubComponent = Components.buildGithubComponent(this);
    }

    public GithubComponent getGithubComponent() {
        return githubComponent;
    }
}
