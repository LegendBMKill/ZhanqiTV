package com.jason.zhanqitv.base;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by Jason on 2017/8/8 0008.
 */

public abstract class BasePresenter<V extends MvpView> extends MvpBasePresenter<V>{
   public abstract void setData();

}
