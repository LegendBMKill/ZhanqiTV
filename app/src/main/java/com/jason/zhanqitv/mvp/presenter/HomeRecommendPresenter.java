package com.jason.zhanqitv.mvp.presenter;

import com.jason.zhanqitv.base.BasePresenter;
import com.jason.zhanqitv.bean.BannerBean;
import com.jason.zhanqitv.bean.BaseModel;
import com.jason.zhanqitv.bean.Recommend;
import com.jason.zhanqitv.http.HomeApi;
import com.jason.zhanqitv.http.RetrofitApi;
import com.jason.zhanqitv.mvp.view.IHomeRecommendView;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class HomeRecommendPresenter extends BasePresenter<IHomeRecommendView> {
    @Override
    public void setData() {
        RetrofitApi.create(HomeApi.class)
                .recommend()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseModel<List<Recommend>>>() {
                    @Override
                    public void accept(@NonNull BaseModel<List<Recommend>> resp) throws Exception {
                        getView().setData(resp.getData());
                    }
                });

        RetrofitApi.create(HomeApi.class)
                .banner()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<BaseModel<List<BannerBean>>>() {
                    @Override
                    public void accept(@NonNull BaseModel<List<BannerBean>> resp) throws Exception {
                        getView().setBannerData(resp.getData());
                    }
                });

    }

}
