package com.jason.zhanqitv.mvp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class HomeViewPagerAdapter extends FragmentPagerAdapter {

    private String[] mTabs;
    private List<Fragment> mFragments;

    public HomeViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, String[] tabs) {
        super(fm);
        mTabs = tabs;
        mFragments = fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabs[position];
    }

}
