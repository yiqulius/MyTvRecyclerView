package com.owen.tvrecyclerview.example.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.owen.adapter.CommonRecyclerViewAdapter;
import com.owen.adapter.CommonRecyclerViewHolder;
import com.owen.tvrecyclerview.example.App;
import com.owen.tvrecyclerview.example.R;
import com.owen.tvrecyclerview.example.data.ItemBean;
import com.owen.tvrecyclerview.manager.MetroGridLayoutManager;
import com.owen.tvrecyclerview.widget.MetroTitleItemDecoration;


public class MetroAdapter extends CommonRecyclerViewAdapter<ItemBean> implements MetroTitleItemDecoration.Adapter {
    public MetroAdapter(Context context) {
        super(context);
    }

    @Override
    public int getItemLayoutId(int viewType) {
        return R.layout.item_recyclerview_maul;
    }

    public void showImage(CommonRecyclerViewHolder helper, int viewId, String url) {
        ImageView imageView = helper.getHolder().getView(viewId);
        Glide.with(App.get()).load(url).into(imageView);
    }

    public void showMoreView(CommonRecyclerViewHolder helper, int viewId) {
        ImageView imageView = helper.getHolder().getView(viewId);
        imageView.setImageResource(R.drawable.content_blue);
    }

    @Override
    public void onBindItemHolder(CommonRecyclerViewHolder helper, ItemBean item, int position) {
        helper.getHolder().setText(R.id.tv_item_title, String.valueOf(position));
//        if (position == 6) {
//            showMoreView(helper, R.id.iv_item);
//        } else {
            showImage(helper, R.id.iv_item, item.imgUrl);
//        }


        final View itemView = helper.itemView;
        MetroGridLayoutManager.LayoutParams lp = (MetroGridLayoutManager.LayoutParams) itemView.getLayoutParams();

        if (position > 61) {
            lp.sectionIndex = 8;
            lp.isSupportIntelligentScrollEnd = false;
            lp.isSupportIntelligentScrollStart = true;
            lp.rowSpan = 2;
            lp.colSpan = 2;
        } else if (position > 51) {
            lp.sectionIndex = 7;
            lp.rowSpan = 2;
            lp.colSpan = 2;
        } else if (position > 43) {
            lp.sectionIndex = 6;
            lp.isSupportIntelligentScrollEnd = false;
            lp.isSupportIntelligentScrollStart = true;
            lp.rowSpan = 4;
            lp.colSpan = 7;
        } else if (position > 35) {
            lp.sectionIndex = 5;
            lp.rowSpan = 4;
            lp.colSpan = 7;
        } else if (position > 27) {
            lp.sectionIndex = 4;
            lp.rowSpan = 4;
            lp.colSpan = 7;
        } else if (position > 20) {
            lp.sectionIndex = 3;
            lp.isSupportIntelligentScrollEnd = false;
            lp.isSupportIntelligentScrollStart = true;
            lp.rowSpan = 7;
            lp.colSpan = 5;
        } else if (position > 13) {
            lp.sectionIndex = 2;
            lp.rowSpan = 7;
            lp.colSpan = 5;
        } else if (position > 6) {
            lp.sectionIndex = 1;
            lp.rowSpan = 7;
            lp.colSpan = 5;
        } else {
            lp.sectionIndex = 0;
            lp.rowSpan = 7;  //height
            lp.colSpan = 5;  //width
        }

        /*app:tv_laneCountsStr="12,60,10,10"
        tv_laneCountsStr / colSpan = 5
        一列 5 个
        */
        itemView.setLayoutParams(lp);
    }

    @Override
    public View getTitleView(int index, RecyclerView parent) {
//        switch (index) {
//            case 1:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title2, parent, false);
//            default:
//                return LayoutInflater.from(parent.getContext()).inflate(R.layout.item_title3, parent, false);
//        }
    }
}
