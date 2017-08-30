package com.jason.zhanqitv.mvp.fragment;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jason.zhanqitv.R;
import com.jason.zhanqitv.base.BaseFragment;
import com.jason.zhanqitv.mvp.adapter.HomeViewPagerAdapter;
import com.jason.zhanqitv.mvp.presenter.HomePresenter;
import com.jason.zhanqitv.mvp.view.IHomeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Jason on 2017/8/25 0025.
 */

public class HomeFragment extends BaseFragment<IHomeView, HomePresenter> implements IHomeView {


    @BindView(R.id.home_tab)
    TabLayout mHomeTab;
    @BindView(R.id.home_vp)
    ViewPager mHomeVp;
    Unbinder unbinder;

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView() {
        String[] tabs = presenter.getTabs();
        List<Fragment> fragments = new ArrayList<>();

        for (int i = 0; i < tabs.length; i++) {
            fragments.add(new HomeContentFragment());
        }

        mHomeTab.setupWithViewPager(mHomeVp);
        HomeViewPagerAdapter pagerAdapter = new HomeViewPagerAdapter(getActivity().getSupportFragmentManager(),fragments,tabs);
        mHomeVp.setAdapter(pagerAdapter);
        mHomeTab.setupWithViewPager(mHomeVp);
        mHomeTab.setTabsFromPagerAdapter(pagerAdapter);

//

//        Toast.makeText(mContext, "asdasd", Toast.LENGTH_SHORT).show();
    }

    @Override
    public HomePresenter createPresenter() {
        return new HomePresenter();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // TODO: inflate a fragment view
        View rootView = super.onCreateView(inflater, container, savedInstanceState);
        unbinder = ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.home_category)
    public void onViewClicked() {
    }
}
