package com.jason.zhanqitv.mvp.presenter;

import com.jason.zhanqitv.base.BasePresenter;
import com.jason.zhanqitv.bean.BaseModel;
import com.jason.zhanqitv.bean.GameListInfo;
import com.jason.zhanqitv.http.HomeApi;
import com.jason.zhanqitv.http.RetrofitApi;
import com.jason.zhanqitv.mvp.view.IHomeGameView;
import com.jason.zhanqitv.util.S;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public class HomeGamePresenter extends BasePresenter<IHomeGameView> {
    public int page = 1;
    private int mCnt;
    private String mTab;

    @Override
    public void setData() {
        Consumer<BaseModel<GameListInfo>> consumer = resp -> {
            mCnt = resp.getData().getCnt();
            getView().setData(resp.getData().getRooms());
        };

        if (mTab.equals("全部")){
            RetrofitApi.create(HomeApi.class)
                    .all(20,page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(consumer);
        }else {
            RetrofitApi.create(HomeApi.class)
                    .game(S.getGameId(mTab),20,page)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(consumer);
        }

    }
    public int getListCount() {
        return mCnt;
    }


    public void setTab(String tab) {
        mTab = tab;
    }
}
