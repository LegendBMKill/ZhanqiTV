package com.jason.zhanqitv.mvp.presenter;

import com.jason.zhanqitv.base.BasePresenter;
import com.jason.zhanqitv.mvp.view.IHomeView;

/**
 * Created by Jason on 2017/8/25 0025.
 */

public class HomePresenter extends BasePresenter<IHomeView>{
    @Override
    public void setData() {

    }

    public String[] getTabs() {
        return new String[]{"推荐","全部","王者荣耀","英雄联盟","三国杀","守望先锋","主机游戏","手机游戏","炉石传说","DOTA2","DNF","射击游戏"};
    }
}
