package com.jason.zhanqitv.mvp.activity;

import android.support.annotation.NonNull;
import android.support.v4.app.FragmentTransaction;
import android.widget.FrameLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.jason.zhanqitv.R;
import com.jason.zhanqitv.base.BaseActivity;
import com.jason.zhanqitv.base.BaseFragment;
import com.jason.zhanqitv.mvp.fragment.HomeFragment;
import com.jason.zhanqitv.mvp.presenter.MainPresenter;
import com.jason.zhanqitv.mvp.view.IMainView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

public class MainActivity extends BaseActivity<IMainView, MainPresenter> implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.fl_root)
    FrameLayout mFlRoot;
    @BindView(R.id.bnb_main)
    BottomNavigationBar mBnbMain;
    private List<BaseFragment> mFragments = new ArrayList<>();
    private List<Integer> index = new ArrayList<>();
    private int mPosition;


    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initView() {
        for (int i = 0; i < 5; i++) {
            mFragments.add(new HomeFragment());
        }
        mBnbMain.setMode(BottomNavigationBar.MODE_FIXED)
                .addItem(new BottomNavigationItem(R.drawable.selector_main_bottom_game, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.selector_main_bottom_yule, "娱乐"))
                .addItem(new BottomNavigationItem(R.drawable.selector_main_bottom_video, "视频"))
                .addItem(new BottomNavigationItem(R.drawable.selector_main_bottom_subscribe, "关注"))
                .addItem(new BottomNavigationItem(R.drawable.selector_main_bottom_mine, "我的"))
                .setBarBackgroundColor("white")
                .setActiveColor(R.color.color_blue)
                .setInActiveColor(R.color.color_gray_7b)
                .setTabSelectedListener(this)
                .initialise();

        mBnbMain.selectTab(0);


    }

    @Override
    public void onRightIv1Pressed() {
        if (mPosition==3){
            toast("订阅管理");
        }else if (mPosition==4){
            toast("设置");
        }else {
            toast("历史");
        }
    }

    @Override
    public void onRightIv2Pressed() {
        toast("搜索");
    }

    @Override
    public void onRightIv3Pressed() {
        toast("排行榜");
    }

    @Override
    public int getLayoutRes() {
        return R.layout.activity_main;
    }

    public void setTitle(int position) {
        mPosition = position;
        resetBarVisibility();
        switch (position) {
            case 0:
                setTitle("首页", 3, R.drawable.zq_main_history_icon, R.drawable.zq_main_search_icon, R.drawable.zq_main_rank_icon);
                break;
            case 1:
                setTitle("娱乐", 3, R.drawable.zq_main_history_icon, R.drawable.zq_main_search_icon, R.drawable.zq_main_rank_icon);
                break;
            case 2:
                setTitle("视频", 3, R.drawable.zq_main_history_icon, R.drawable.zq_main_search_icon, R.drawable.zq_main_rank_icon);
                break;
            case 3:
                setTitle("关注", 1, R.drawable.zq_main_subscribe_icon);
                break;
            case 4:
                setTitle("我的", 1, R.drawable.zq_main_setting_icon);
                break;
        }
    }

    @Override
    public void onTabSelected(int position) {
        setTitle(position);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (!index.contains(position)) {
            index.add(position);
            transaction.add(mFlRoot.getId(), mFragments.get(position));
        } else {
            transaction.show(mFragments.get(position));
        }
        transaction.commit();
    }

    @Override
    public void onTabUnselected(int position) {
        getSupportFragmentManager().beginTransaction()
                .hide(mFragments.get(position))
                .commit();
    }

    @Override
    public void onTabReselected(int position) {
    }
}
