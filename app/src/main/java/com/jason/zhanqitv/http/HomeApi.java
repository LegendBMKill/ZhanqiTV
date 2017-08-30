package com.jason.zhanqitv.http;

import com.jason.zhanqitv.bean.BannerBean;
import com.jason.zhanqitv.bean.BaseModel;
import com.jason.zhanqitv.bean.Recommend;
import com.jason.zhanqitv.constants.C;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public interface HomeApi {
    @GET(C.RECOMMEND_URL)
    Observable<BaseModel<List<Recommend>>> recommend();
    @GET(C.BANNER_URL)
    Observable<BaseModel<List<BannerBean>>> banner();
}
