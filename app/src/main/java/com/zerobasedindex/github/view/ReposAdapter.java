package com.zerobasedindex.github.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.zerobasedindex.github.databinding.ItemRepoBinding;
import com.zerobasedindex.github.model.Repo;

import java.util.List;

/**
 * Copyright 2015 Cody Henthorne
 */
public class ReposAdapter extends BaseAdapter<Repo> {

    public ReposAdapter(Context context) {
        super(context);
    }

    public ReposAdapter(Context context, List<Repo> repos) {
        super(context, repos);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemRepoBinding binding = ItemRepoBinding.inflate(layoutInflater, parent, false);
        Log.e("CODY", "binding: " + binding);
        return new RepoViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((RepoViewHolder)holder).bind(list.get(position));
    }

    private class RepoViewHolder extends RecyclerView.ViewHolder {
        private final ItemRepoBinding repoBinding;
        private final View rootView;

        public RepoViewHolder(ItemRepoBinding repoBinding) {
            super(repoBinding.getRoot());
            rootView = repoBinding.getRoot();
            this.repoBinding = repoBinding;
        }

        public void bind(Repo repo) {
            repoBinding.setRepo(repo);
            if (repoListener != null) {
                rootView.setOnClickListener(v -> repoListener.click(repo));
            }
        }
    }

}
