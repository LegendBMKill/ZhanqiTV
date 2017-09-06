package com.jason.zhanqitv.mvp.fragment;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.jason.zhanqitv.R;
import com.jason.zhanqitv.base.BaseFragment;
import com.jason.zhanqitv.bean.GameListInfo;
import com.jason.zhanqitv.mvp.adapter.ThumbListAdapter;
import com.jason.zhanqitv.mvp.presenter.HomeGamePresenter;
import com.jason.zhanqitv.mvp.view.IHomeGameView;
import com.youth.banner.Banner;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class HomeGameFragment extends BaseFragment<IHomeGameView, HomeGamePresenter> implements IHomeGameView, SwipeRefreshLayout.OnRefreshListener {
    private final String mTab;
    @BindView(R.id.game_rv)
    RecyclerView mGameRv;
    @BindView(R.id.srl)
    SwipeRefreshLayout mRefreshLayout;

    private List<GameListInfo> mRecommends;
    private ThumbListAdapter mAdapter;
    private Banner mBanner;

    public HomeGameFragment(String tab) {
        mTab = tab;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home_game;
    }

    @Override
    protected void initView() {
        mGameRv.setLayoutManager(new GridLayoutManager(mContext,2));
        mAdapter = new ThumbListAdapter(mRecommends);
        mGameRv.setAdapter(mAdapter);

        mRefreshLayout.setColorSchemeColors(getActivity().getResources().getColor(R.color.color_blue));
        mRefreshLayout.setOnRefreshListener(this);

        mAdapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                if (mAdapter.getItemCount()<presenter.getListCount()){
                    presenter.page++;
                    presenter.setData();
                    mAdapter.loadMoreComplete();
                }else {
                    mAdapter.loadMoreEnd();
                }
            }
        },mGameRv);
        presenter.setTab(mTab);
        presenter.setData();
    }


    @Override
    public HomeGamePresenter createPresenter() {
        return new HomeGamePresenter();
    }

    @Override
    public void setData(List<GameListInfo> list) {
        if (presenter.page!=1){
            mAdapter.addData(list);
        }else {
            mAdapter.setNewData(list);
        }
        mRefreshLayout.setRefreshing(false);
    }


    @Override
    public void onRefresh() {
        mRefreshLayout.setRefreshing(true);
        presenter.page=1;
        presenter.setData();
    }



}
