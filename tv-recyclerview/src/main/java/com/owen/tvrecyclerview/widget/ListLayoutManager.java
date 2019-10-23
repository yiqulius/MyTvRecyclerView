package com.owen.tvrecyclerview.widget;

import android.content.Context;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.util.AttributeSet;

import com.owen.tvrecyclerview.manager.BaseLayoutManager;
import com.owen.tvrecyclerview.Lanes.LaneInfo;


public class ListLayoutManager extends BaseLayoutManager {
    private static final String LOGTAG = "ListLayoutManager";

    public ListLayoutManager(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ListLayoutManager(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ListLayoutManager(Context context, Orientation orientation) {
        super(orientation);
    }

    @Override
    public int getLaneCount() {
        return 1;
    }

    @Override
    public void getLaneForPosition(LaneInfo outInfo, int position, Direction direction) {
        outInfo.set(0, 0);
    }

    @Override
    protected void moveLayoutToPosition(int position, int offset, Recycler recycler, State state) {
        getLanes().reset(offset);
    }

}