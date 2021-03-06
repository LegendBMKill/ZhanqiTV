package com.jason.zhanqitv.mvp.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.jason.zhanqitv.R;
import com.jason.zhanqitv.bean.GameListInfo;
import com.jason.zhanqitv.util.GlideApp;
import com.jason.zhanqitv.widget.RoundImageView;

import java.util.List;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class ThumbListAdapter extends BaseQuickAdapter<GameListInfo,BaseViewHolder> {
    public ThumbListAdapter(@Nullable List<GameListInfo> data) {
        this(R.layout.adapter_list_thumb,data);
    }

    public ThumbListAdapter(@LayoutRes int layoutResId, @Nullable List<GameListInfo> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, GameListInfo item) {

        helper.setText(R.id.item_title,item.getTitle())
                .setText(R.id.item_name,item.getNickname())
                .setText(R.id.item_persons,String.valueOf(item.getOnline()));

        RoundImageView imageView = helper.getView(R.id.item_thumb);
        GlideApp.with(mContext).load(item.getSpic()).placeholder(R.drawable.meipai_default_cover_image).centerCrop().into(imageView);
    }
}
