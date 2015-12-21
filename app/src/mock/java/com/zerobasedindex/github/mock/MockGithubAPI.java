package com.zerobasedindex.github.mock;

import com.zerobasedindex.github.data.GithubAPI;
import com.zerobasedindex.github.model.FullCommit;
import com.zerobasedindex.github.model.Repo;

import java.util.List;

import retrofit.http.Path;
import rx.Observable;

/**
 * Copyright 2015 Cody Henthorne
 */
public class MockGithubAPI implements GithubAPI {
    @Override
    public Observable<List<Repo>> getRepos(@Path("user") String user) {
        return Observable.just(MockGithubData.REPOS);
    }

    @Override
    public Observable<List<FullCommit>> getCommit(@Path("user") String user, @Path("repo") String repo) {
        return Observable.just(MockGithubData.COMMITS);
    }
}
