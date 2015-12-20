package com.zerobasedindex.github.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zerobasedindex.github.R;
import com.zerobasedindex.github.model.Repo;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

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
        return new RepoViewHolder(layoutInflater.inflate(R.layout.item_repo, parent, false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Log.e("CODY", "position: " + position);
        ((RepoViewHolder)holder).bind(list.get(position));
    }

    @Override
    public long getItemId(int position) {
        return list.get(position).getId();
    }

    class RepoViewHolder extends RecyclerView.ViewHolder {
        private final View rootView;
        @Bind(R.id.item_repo_name) TextView name;
        @Bind(R.id.item_repo_desc) TextView desc;

        public RepoViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            ButterKnife.bind(this, rootView);
        }

        public void bind(Repo repo) {
            name.setText(repo.getName());
            desc.setText(repo.getDescription());
            if (repoListener != null) {
                rootView.setOnClickListener(v -> repoListener.click(repo));
            }
        }
    }

}
