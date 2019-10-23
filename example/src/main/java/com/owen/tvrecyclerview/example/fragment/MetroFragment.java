package com.owen.tvrecyclerview.example.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.owen.adapter.CommonRecyclerViewAdapter;
import com.owen.adapter.CommonRecyclerViewHolder;
import com.owen.tvrecyclerview.manager.TwoWayLayoutManager;
import com.owen.tvrecyclerview.example.R;
import com.owen.tvrecyclerview.example.adapter.MetroAdapter;
import com.owen.tvrecyclerview.example.data.ItemDatas;
import com.owen.tvrecyclerview.manager.MetroGridLayoutManager;
import com.owen.tvrecyclerview.widget.MetroTitleItemDecoration;
import com.owen.tvrecyclerview.widget.SimpleOnItemListener;
import com.owen.tvrecyclerview.widget.TvRecyclerView;

import java.util.List;

import butterknife.BindView;

public class MetroFragment extends BaseFragment {

    @BindView(R.id.list) TvRecyclerView mRecyclerView;
    
    @BindView(R.id.list_menu) TvRecyclerView mMenuView;
    
    private MetroAdapter mAdapter;
    private MenuAdapter mMenuAdapter;
    private int mCurSelectedMenuPosition = 0;

    String[] tv_ = new String[]{"Home","Movies","TV Play","Music","Apps"};

    public static MetroFragment newInstance() {
        MetroFragment fragment = new MetroFragment();
        return fragment;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setListener();
        
        mMenuView.setSpacingWithMargins(35, 0);
        mMenuAdapter = new MenuAdapter(getContext(), ItemDatas.getDatas(5));
        mMenuView.setAdapter(mMenuAdapter);
        
        mAdapter = new MetroAdapter(getContext());
        mAdapter.setDatas(ItemDatas.getDatas(90));
        
        MetroGridLayoutManager layoutManager = new MetroGridLayoutManager
        (TwoWayLayoutManager.Orientation.VERTICAL, 35,35,35,35,28,28,28,10,10);
        mRecyclerView.setLayoutManager(layoutManager);
        String[] data = new String[]{"Comedy","Drama","Action","Thriller","Social","Animation","Life Style","Pop","Soundtrack"};
        mRecyclerView.addItemDecoration(new MetroTitleItemDecoration(mAdapter, data));//设置title
        mRecyclerView.setSpacingWithMargins(15, 15);//设置行列间距
        mRecyclerView.setAdapter(mAdapter);
    }

    private void setListener() {

        mMenuView.setOnItemListener(new SimpleOnItemListener() {
            @Override
            public void onItemSelected(TvRecyclerView parent, View itemView, int position) {
                if(mCurSelectedMenuPosition != position) {
                    mCurSelectedMenuPosition = position;
                    switch (mCurSelectedMenuPosition) {
                        case 0:
                            mRecyclerView.smoothScrollToPosition(0);
                            break;
                        case 1:
                            mRecyclerView.smoothScrollToPosition(14);
                            break;
                        case 2:
                            mRecyclerView.smoothScrollToPosition(28);
                            break;
                        case 3:
                            mRecyclerView.smoothScrollToPosition(42);
                            break;
                        case 4:
                            mRecyclerView.smoothScrollToPosition(49);
                            break;
                    }
                }
            }
        });
        
        mRecyclerView.setOnItemListener(new SimpleOnItemListener() {

            @Override
            public void onItemClick(TvRecyclerView parent, View itemView, int position) {
                showToast("onItemClick::"+position);
            }
        });

    }

    @Override
    public int getLayoutId() {
        return R.layout.layout_metro_grid;
    }

    private class MenuAdapter extends CommonRecyclerViewAdapter {

        public MenuAdapter(Context context, List datas) {
            super(context, datas);
        }

        @Override
        public int getItemLayoutId(int viewType) {
            return R.layout.item_list_menu;
        }

        @Override
        public void onBindItemHolder(CommonRecyclerViewHolder helper, Object item, int position) {
            helper.getHolder().setText(R.id.title, tv_[position]);
        }
    }
}
