package com.zerobasedindex.github.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.zerobasedindex.github.databinding.ItemCommitBinding;
import com.zerobasedindex.github.model.FullCommit;

import java.util.List;

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
        return new CommitViewHolder(ItemCommitBinding.inflate(layoutInflater, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((CommitViewHolder)holder).bind(list.get(position));
    }

    private class CommitViewHolder extends RecyclerView.ViewHolder {
        private final ItemCommitBinding repoBinding;
        private final View rootView;

        public CommitViewHolder(ItemCommitBinding repoBinding) {
            super(repoBinding.getRoot());
            rootView = repoBinding.getRoot();
            this.repoBinding = repoBinding;
        }

        public void bind(FullCommit commit) {
            repoBinding.setFullCommit(commit);
            if (repoListener != null) {
                rootView.setOnClickListener(v -> repoListener.click(commit));
            }
        }
    }
}
