package com.zerobasedindex.github.data;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit.Retrofit;

@Module
public class GithubModule {

    @Singleton
    @Provides
    public GithubAPI provideGithubAPI(Retrofit retrofit) {
        return retrofit.create(GithubAPI.class);
    }

    @Singleton
    @Provides
    public GithubDM provideGithubDM(GithubAPI githubAPI) {
        return new GithubDM(githubAPI);
    }

}
