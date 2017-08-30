package com.jason.zhanqitv.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hannesdorfmann.mosby3.mvp.MvpFragment;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Jason on 2017/8/24 0024.
 */

public abstract class BaseFragment<V extends MvpView, P extends MvpPresenter<V>> extends MvpFragment<V,P> {

    public Context mContext;
    private View rootView;
    private Unbinder mBind;

    /**
     * 当前界面是否呈现给用户的状态标志
     */
    protected boolean isVisible;
    protected boolean isPrepared = false;



    protected abstract int getLayoutId();
    protected abstract void initView();

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBind = ButterKnife.bind(this, view);
        isPrepared = true;
        initView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mBind.unbind();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mContext = activity;
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (rootView == null) {    //初次加载
            if (getLayoutId() > 0) {
                rootView = inflater.inflate(getLayoutId(), container, false);
            } else {
                rootView = super.onCreateView(inflater, container, savedInstanceState);
            }
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) parent.removeView(rootView);
        }
        return rootView;
    }

    /**
     * 重写Fragment父类生命周期方法，在onCreate之前调用该方法，实现Fragment数据的缓加载.
     * @param isVisibleToUser 当前是否已将界面显示给用户的状态
     */
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 当界面呈现给用户，即设置可见时执行，进行加载数据的方法
     * 在用户可见时加载数据，而不在用户不可见的时候加载数据，是为了防止控件对象出现空指针异常
     */
    protected void onVisible(){
        lazyLoad();
    }

    /**
     * 当界面还没呈现给用户，即设置不可见时执行
     */
    protected void onInvisible(){

    }

    /**
     * 加载数据方法
     */
    protected void lazyLoad(){

    }

}
