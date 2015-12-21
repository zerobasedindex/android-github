package com.zerobasedindex.github.mock;

import com.zerobasedindex.github.AppModule;
import com.zerobasedindex.github.data.GithubComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Copyright 2015 Cody Henthorne
 */
@Singleton
@Component(modules = {AppModule.class, MockNetworkModule.class, MockGithubModule.class})
public interface MockGithubComponent extends GithubComponent {

}
