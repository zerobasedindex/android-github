package com.zerobasedindex.github.data;

import com.zerobasedindex.github.model.FullCommit;
import com.zerobasedindex.github.model.Repo;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import rx.schedulers.Schedulers;

/**
 * Copyright 2015 Cody Henthorne
 */
public class GithubDM {

    private GithubAPI githubApi;

    private List<Repo> repos;

    public GithubDM(GithubAPI githubAPI) {
        this.githubApi = githubAPI;
    }

    public rx.Observable<List<Repo>> listRepos(String name) {
        return githubApi.getRepos(name)
                .doOnNext(repos -> this.repos = repos)
                .subscribeOn(Schedulers.io());
    }

    public rx.Observable<List<FullCommit>> listCommits(String user, String repo) {
        return githubApi.getCommit(user, repo)
                .subscribeOn(Schedulers.io());
    }

    public List<Repo> getRepos() {
        return repos;
    }

    public Repo getRepo(long repoId) {
        for (Repo repo : getRepos()) {
            if (repo.getId() == repoId) {
                return repo;
            }
        }
        return null;
    }
}
