package com.jason.zhanqitv.mvp.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jason.zhanqitv.R;
import com.jason.zhanqitv.bean.GameListInfo;
import com.jason.zhanqitv.bean.Recommend;
import com.jason.zhanqitv.constants.C;
import com.jason.zhanqitv.mvp.activity.RoomActivity;
import com.jason.zhanqitv.util.GlideApp;

import java.util.List;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class HomeRecommendAdapter extends BaseQuickAdapter<Recommend, BaseViewHolder> {

    public HomeRecommendAdapter(Context context, @Nullable List<Recommend> data) {
        this(R.layout.adapter_home_recommend, data);
    }

    public HomeRecommendAdapter(@LayoutRes int layoutResId, @Nullable List<Recommend> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Recommend item) {
        if (helper.getLayoutPosition() == 1) {
            helper.setText(R.id.item_more, "换一批");
        }
        ImageView icon = helper.getView(R.id.item_icon);
        GlideApp.with(mContext).load(item.getIcon()).into(icon);
        helper.setText(R.id.item_title, item.getTitle())
                 .addOnClickListener(R.id.item_rv);

        RecyclerView recyclerView = helper.getView(R.id.item_rv);

        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        ThumbListAdapter adapter = new ThumbListAdapter(R.layout.adapter_list_thumb, item.getLists().subList(0,4));
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                GameListInfo info = (GameListInfo) adapter.getData().get(position);
                mContext.startActivity(new Intent(mContext, RoomActivity.class).putExtra(C.GAME_INFO,info));
            }
        });

    }


}
