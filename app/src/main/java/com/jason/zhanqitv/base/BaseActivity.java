package com.jason.zhanqitv.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.hannesdorfmann.mosby3.mvp.MvpActivity;
import com.hannesdorfmann.mosby3.mvp.MvpPresenter;
import com.hannesdorfmann.mosby3.mvp.MvpView;
import com.jason.zhanqitv.R;
import com.jason.zhanqitv.constants.C;
import com.jason.zhanqitv.util.StackUtils;

import butterknife.ButterKnife;
import butterknife.Unbinder;


/**
 * Created by Jason on 2017/8/8 0008.
 */

public abstract class BaseActivity<V extends MvpView, P extends MvpPresenter<V>> extends MvpActivity<V, P> implements View.OnClickListener {

    public Context mContext;
    private Unbinder mUnbinder;
    private RelativeLayout mTitleBar;
    public String TAG = "debug";
    private ImageView mBack;
    private ImageView mRIv1;
    private ImageView mRIv2;
    private ImageView mRIv3;
    private TextView mTitle;
    private TextView mRTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
        setContentView(this.getLayoutRes());
        mUnbinder = ButterKnife.bind(this);
        initTitleBar();
        initView();

        //堆栈管理器
        StackUtils.getInstanse().addActivity(this);
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bar_back:
                onBackPressed();
                break;
            case R.id.bar_r_iv1:
                onRightIv1Pressed();
                break;
            case R.id.bar_r_iv2:
                onRightIv2Pressed();
                break;
            case R.id.bar_r_iv3:
                onRightIv3Pressed();
                break;
            case R.id.bar_tv:
                onRightTvPressed();
                break;
        }
    }

    public void onRightIv1Pressed() {
    }

    public void onRightIv2Pressed() {
    }

    public void onRightIv3Pressed() {
    }

    public void onRightTvPressed() {
    }

    public void resetBarVisibility() {
        mBack.setVisibility(View.GONE);
        mRIv1.setVisibility(View.GONE);
        mRIv2.setVisibility(View.GONE);
        mRIv3.setVisibility(View.GONE);
        mRTv.setVisibility(View.GONE);
    }

    public void setTitle(String title) {
        setTitle(title, false, "", 0, 0);
    }

    public void setTitle(String title, boolean needBack) {
        setTitle(title, needBack, "", 0, 0);
    }

    public void setTitle(String title, String rightTvString) {
        setTitle(title, false, rightTvString, 0, 0);
    }

    public void setTitle(String title, boolean needBack, String rightTvString) {
        setTitle(title, needBack, rightTvString, 0, 0);
    }

    public void setTitle(String title, int rightIconNum, int... resId) {
        setTitle(title, false, "", rightIconNum, resId);
    }

    public void setTitle(String title, boolean needBack, int rightIconNum, int... resId) {
        setTitle(title, needBack, "", rightIconNum, resId);
    }

    public void setTitle(String title, boolean needBack, String rightTvString, int rightIconNum, int... resId) {
        if (mTitleBar == null) return;

        mTitle.setText(title);

        if (needBack) {
            mBack.setVisibility(View.VISIBLE);
        }

        if (!TextUtils.isEmpty(rightTvString)) {
            mRTv.setVisibility(View.VISIBLE);
            mRTv.setText(rightTvString);
            return;
        }
        switch (rightIconNum) {
            case 1:
                if (resId.length < 1) return;
                mRIv1.setVisibility(View.VISIBLE);
                mRIv1.setImageResource(resId[0]);
                break;
            case 2:
                if (resId.length < 2) return;
                mRIv1.setVisibility(View.VISIBLE);
                mRIv2.setVisibility(View.VISIBLE);
                mRIv1.setImageResource(resId[0]);
                mRIv2.setImageResource(resId[1]);
                break;
            case 3:
                if (resId.length < 3) return;
                mRIv1.setVisibility(View.VISIBLE);
                mRIv2.setVisibility(View.VISIBLE);
                mRIv3.setVisibility(View.VISIBLE);
                mRIv1.setImageResource(resId[0]);
                mRIv2.setImageResource(resId[1]);
                mRIv3.setImageResource(resId[2]);
                break;
        }
    }


    protected abstract void initView();

    public abstract int getLayoutRes();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mUnbinder.unbind();
        StackUtils.getInstanse().finishActivity(this);
    }

    public void initTitleBar() {
        if (mTitleBar == null) {
            mTitleBar = (RelativeLayout) getWindow().getDecorView().findViewWithTag(C.TITLE_TAG);
        }

        mBack = (ImageView) mTitleBar.findViewById(R.id.bar_back);
        mRIv1 = (ImageView) mTitleBar.findViewById(R.id.bar_r_iv1);
        mRIv2 = (ImageView) mTitleBar.findViewById(R.id.bar_r_iv2);
        mRIv3 = (ImageView) mTitleBar.findViewById(R.id.bar_r_iv3);
        mTitle = (TextView) mTitleBar.findViewById(R.id.bar_title);
        mRTv = (TextView) mTitleBar.findViewById(R.id.bar_tv);

        mBack.setOnClickListener(this);
        mRIv1.setOnClickListener(this);
        mRIv2.setOnClickListener(this);
        mRIv3.setOnClickListener(this);
        mTitle.setOnClickListener(this);
        mRTv.setOnClickListener(this);
    }


    public void toast(String message) {
        Toast.makeText(mContext, message, Toast.LENGTH_LONG).show();
    }


}
