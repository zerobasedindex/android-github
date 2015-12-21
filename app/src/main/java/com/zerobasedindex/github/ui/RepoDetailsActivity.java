package com.zerobasedindex.github.ui;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ImageView;

import com.f2prateek.dart.InjectExtra;
import com.squareup.picasso.Picasso;
import com.zerobasedindex.github.R;
import com.zerobasedindex.github.base.BaseActivity;
import com.zerobasedindex.github.data.GithubDM;
import com.zerobasedindex.github.model.Repo;
import com.zerobasedindex.github.view.CommitsAdapter;

import javax.inject.Inject;

import butterknife.Bind;
import rx.android.schedulers.AndroidSchedulers;

public class RepoDetailsActivity extends BaseActivity {

    public static final String REPO_ID_EXTRA = "repo_id";

    @InjectExtra("repo_id") long repoId;

    @Bind(R.id.collapsing_toolbar) CollapsingToolbarLayout collapsingToolbar;
    @Bind(R.id.toolbar) Toolbar toolbar;
    @Bind(R.id.backdrop) ImageView backdropImg;
    @Bind(R.id.recyclerView) RecyclerView recyclerView;

    @Inject GithubDM githubDM;
    @Inject Picasso picasso;

    private Repo repo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_repo_details);
        getGithubApplication().getGithubComponent().inject(this);

        repo = githubDM.getRepo(repoId);

        super.setSupportActionBar(toolbar);
        super.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        super.setTitle(repo.getName());
        collapsingToolbar.setTitle(repo.getName());

        picasso.load(repo.getOwner().getAvatarUrl())
                .into(backdropImg);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new CommitsAdapter(this));

        githubDM.listCommits(repo.getOwner().getLogin(), repo.getName())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(commits -> {
                    CommitsAdapter adapter = new CommitsAdapter(this, commits);
                    recyclerView.swapAdapter(adapter, false);
                }, throwable -> Log.e("CODY", Log.getStackTraceString(throwable)));


    }
}
