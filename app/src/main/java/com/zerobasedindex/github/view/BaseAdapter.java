package com.zerobasedindex.github.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;

import java.util.Collections;
import java.util.List;

/**
 * Copyright 2015 Cody Henthorne
 */
public abstract class BaseAdapter<Type> extends RecyclerView.Adapter {

    protected final List<Type> list;
    protected final LayoutInflater layoutInflater;
    protected ClickListener<Type> repoListener;

    public BaseAdapter(Context context) {
        this(context, Collections.emptyList());
    }

    public BaseAdapter(Context context, List<Type> repos) {
        layoutInflater = LayoutInflater.from(context);
        list = repos;
        super.setHasStableIds(true);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void setListener(ClickListener<Type> listener) {
        this.repoListener = listener;
    }

    public interface ClickListener<Type> {
        void click(Type data);
    }
}
