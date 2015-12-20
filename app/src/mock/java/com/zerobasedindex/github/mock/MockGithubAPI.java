package com.zerobasedindex.github.mock;

import com.zerobasedindex.github.data.GithubAPI;
import com.zerobasedindex.github.model.Commit;
import com.zerobasedindex.github.model.FullCommit;
import com.zerobasedindex.github.model.Owner;
import com.zerobasedindex.github.model.Repo;

import java.util.ArrayList;
import java.util.List;

import retrofit.http.Path;
import rx.Observable;

/**
 * Copyright 2015 Cody Henthorne
 */
public class MockGithubAPI implements GithubAPI {
    @Override
    public Observable<List<Repo>> getRepos(@Path("user") String user) {
        List<Repo> repos = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            repos.add(new Repo(i, "Test Repo " + i, "This is my desc.", new Owner("TestOwner", "https://avatars2.githubusercontent.com/u/66577?v=3&s=400")));
        }
        return Observable.just(repos);
    }

    @Override
    public Observable<List<FullCommit>> getCommit(@Path("user") String user, @Path("repo") String repo) {
        List<FullCommit> commits = new ArrayList<>(100);
        for (int i = 0; i < 100; i++) {
            commits.add(new FullCommit("SHA"+i, new Commit("This is my message")));
        }
        return Observable.just(commits);
    }
}
