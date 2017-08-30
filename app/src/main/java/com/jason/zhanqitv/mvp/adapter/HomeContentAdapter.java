package com.jason.zhanqitv.mvp.adapter;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jason.zhanqitv.R;
import com.jason.zhanqitv.bean.Recommend;
import com.jason.zhanqitv.util.GlideApp;
import com.jason.zhanqitv.util.S;

import java.util.List;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class HomeContentAdapter extends BaseQuickAdapter<Recommend, BaseViewHolder> {

    public HomeContentAdapter(Context context, @Nullable List<Recommend> data) {
        this(R.layout.adapter_home_recommend, data);
    }

    public HomeContentAdapter(@LayoutRes int layoutResId, @Nullable List<Recommend> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Recommend item) {
        if (helper.getLayoutPosition() == 1) {
            helper.setText(R.id.item_more, "换一批");
        }
        ImageView icon = helper.getView(R.id.item_icon);
        GlideApp.with(mContext).load(item.getIcon()).into(icon);
        helper.setText(R.id.item_title, item.getTitle());

        RecyclerView recyclerView = helper.getView(R.id.item_rv);

        recyclerView.removeItemDecoration(decor);
        recyclerView.addItemDecoration(decor);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 2));
        ThumbListAdapter adapter = new ThumbListAdapter(R.layout.adapter_list_thumb, item.getLists().subList(0,4));
        recyclerView.setAdapter(adapter);

    }

   static RecyclerView.ItemDecoration decor = new RecyclerView.ItemDecoration() {
        @Override
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            //不是第一个的格子都设一个左边和底部的间距
            outRect.left = S.dip2px(12);
            outRect.bottom = S.dip2px(12);
            //由于每行都只有3个，所以第一个都是3的倍数，把左边距设为0
            if (parent.getChildLayoutPosition(view) % 2 == 0) {
                outRect.left = 0;
            }
        }
    };
}
