package com.zerobasedindex.github.data;

import com.zerobasedindex.github.model.FullCommit;
import com.zerobasedindex.github.model.Repo;

import java.util.List;

import retrofit.http.GET;
import retrofit.http.Path;
import rx.Observable;

public interface GithubAPI {

    @GET("users/{user}/repos")
    Observable<List<Repo>> getRepos(@Path("user") String user);

    @GET("repos/{user}/{repo}/commits")
    Observable<List<FullCommit>> getCommit(@Path("user") String user, @Path("repo") String repo);

}
