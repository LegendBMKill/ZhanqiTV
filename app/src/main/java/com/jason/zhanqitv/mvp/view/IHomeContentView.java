package com.jason.zhanqitv.mvp.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.jason.zhanqitv.bean.BannerBean;
import com.jason.zhanqitv.bean.Recommend;

import java.util.List;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public interface IHomeContentView extends MvpView {

    void setData(List<Recommend> list);
    void setBannerData(List<BannerBean> list);
}
