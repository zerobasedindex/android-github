package com.zerobasedindex.github.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zerobasedindex.github.R;
import com.zerobasedindex.github.model.FullCommit;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Copyright 2015 Cody Henthorne
 */
public class CommitsAdapter extends BaseAdapter<FullCommit> {
    public CommitsAdapter(Context context) {
        super(context);
    }

    public CommitsAdapter(Context context, List<FullCommit> repos) {
        super(context, repos);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new CommitViewHolder(layoutInflater.inflate(R.layout.item_commit, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CommitViewHolder)holder).bind(list.get(position));
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getSha().hashCode();
    }

    class CommitViewHolder extends RecyclerView.ViewHolder {
        private final View rootView;
        @Bind(R.id.item_commit_sha) TextView sha;
        @Bind(R.id.item_commit_message) TextView message;

        public CommitViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            ButterKnife.bind(this, rootView);
        }

        public void bind(FullCommit commit) {
            sha.setText(commit.getSha());
            message.setText(commit.getCommit().getMessage());
            if (repoListener != null) {
                rootView.setOnClickListener(v -> repoListener.click(commit));
            }
        }
    }
}
