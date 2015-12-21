package com.zerobasedindex.github.data;

import com.zerobasedindex.github.AppModule;
import com.zerobasedindex.github.network.NetworkModule;
import com.zerobasedindex.github.ui.MainActivity;
import com.zerobasedindex.github.ui.RepoDetailsActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, NetworkModule.class, GithubModule.class})
public interface GithubComponent {
    void inject(MainActivity activity);
    void inject(RepoDetailsActivity activity);
}
