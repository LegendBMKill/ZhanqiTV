package com.jason.zhanqitv.mvp.fragment;

import android.content.Context;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jason.zhanqitv.R;
import com.jason.zhanqitv.base.BaseFragment;
import com.jason.zhanqitv.bean.BannerBean;
import com.jason.zhanqitv.bean.Recommend;
import com.jason.zhanqitv.mvp.adapter.HomeRecommendAdapter;
import com.jason.zhanqitv.mvp.presenter.HomeRecommendPresenter;
import com.jason.zhanqitv.mvp.view.IHomeRecommendView;
import com.jason.zhanqitv.util.GlideApp;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class HomeRecommendFragment extends BaseFragment<IHomeRecommendView, HomeRecommendPresenter> implements IHomeRecommendView, SwipeRefreshLayout.OnRefreshListener {
    @BindView(R.id.content_rv)
    RecyclerView mContentRv;
    @BindView(R.id.content_srl)
    SwipeRefreshLayout mContentSrl;

    private List<Recommend> mRecommends;
    private HomeRecommendAdapter mAdapter;
    private Banner mBanner;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_content;
    }

    @Override
    protected void initView() {
        mContentRv.setLayoutManager(new LinearLayoutManager(mContext));
        mAdapter = new HomeRecommendAdapter(mContext, mRecommends);
        mContentRv.setAdapter(mAdapter);

        mAdapter.setOnItemChildClickListener(new BaseQuickAdapter.OnItemChildClickListener() {
            @Override
            public void onItemChildClick(BaseQuickAdapter adapter, View view, int position) {
            }
        });

        View headerView = View.inflate(mContext, R.layout.header_banner, null);
        mAdapter.addHeaderView(headerView);


        mContentSrl.setColorSchemeColors(getActivity().getResources().getColor(R.color.color_blue));
        mContentSrl.setOnRefreshListener(this);

        mBanner = (Banner) headerView.findViewById(R.id.banner);
        initBanner();

        presenter.setData();
    }

    private void initBanner() {

        //设置banner样式
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);
        //设置图片加载器
        mBanner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                GlideApp.with(context).load(path).into(imageView);
            }
        });
        //设置banner动画效果
        mBanner.setBannerAnimation(Transformer.Default);
        //设置自动轮播，默认为true
        mBanner.isAutoPlay(true);
        //设置轮播时间
        mBanner.setDelayTime(5000);
        //设置指示器位置（当banner模式中有指示器时）
        mBanner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE | BannerConfig.RIGHT);
    }

    @Override
    public HomeRecommendPresenter createPresenter() {
        return new HomeRecommendPresenter();
    }

    @Override
    public void setData(List<Recommend> list) {
        mAdapter.setNewData(list);
        mContentSrl.setRefreshing(false);
    }

    @Override
    public void setBannerData(List<BannerBean> list) {
        List<String> titles = new ArrayList<>();
        List<String> imgs = new ArrayList<>();

        for (BannerBean bannerBean : list) {
            titles.add(bannerBean.getTitle());
            imgs.add(bannerBean.getSpic());
        }

        mBanner.setBannerTitles(titles);
        mBanner.setImages(imgs);
        mBanner.start();
    }

    @Override
    public void onRefresh() {
        mContentSrl.setRefreshing(true);
        presenter.setData();
    }



}
