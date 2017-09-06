package com.jason.zhanqitv.mvp.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.jason.zhanqitv.bean.GameListInfo;

import java.util.List;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public interface IHomeGameView extends MvpView {

    void setData(List<GameListInfo> list);
}
