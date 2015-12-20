package com.zerobasedindex.github.mock;

import com.zerobasedindex.github.data.GithubComponent;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Copyright 2015 Cody Henthorne
 */
@Singleton
@Component(modules = MockGithubModule.class)
public interface MockGithubComponent extends GithubComponent {

}
