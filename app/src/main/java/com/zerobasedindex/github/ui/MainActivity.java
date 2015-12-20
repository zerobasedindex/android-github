package com.zerobasedindex.github.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.zerobasedindex.github.R;
import com.zerobasedindex.github.base.BaseActivity;
import com.zerobasedindex.github.data.GithubDM;
import com.zerobasedindex.github.view.ReposAdapter;

import javax.inject.Inject;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;

public class MainActivity extends BaseActivity {

    @Bind(R.id.recyclerView) RecyclerView recyclerView;
    @Inject GithubDM githubDM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_main);
        getGithubApplication().getGithubComponent().inject(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ReposAdapter(this));

        githubDM.listRepos("ChrisGuzman")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(repos -> {
                    ReposAdapter adapter = new ReposAdapter(this, repos);
                    adapter.setListener(repo -> {
                        Intent intent = Henson.with(this)
                                .gotoRepoDetailsActivity()
                                .repo_id(repo.getId())
                                .build();
                        super.startActivity(intent);
                    });
                    recyclerView.swapAdapter(adapter, false);
                }, throwable -> Log.e("CODY", Log.getStackTraceString(throwable)));
    }
}
