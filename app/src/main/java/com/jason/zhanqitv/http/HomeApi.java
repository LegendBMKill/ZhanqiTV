package com.jason.zhanqitv.http;

import com.jason.zhanqitv.bean.BannerBean;
import com.jason.zhanqitv.bean.BaseModel;
import com.jason.zhanqitv.bean.GameListInfo;
import com.jason.zhanqitv.bean.Recommend;
import com.jason.zhanqitv.constants.C;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Jason on 2017/8/30 0030.
 */

public interface HomeApi {
    @GET(C.RECOMMEND_URL)
    Observable<BaseModel<List<Recommend>>> recommend();
    @GET(C.BANNER_URL)
    Observable<BaseModel<List<BannerBean>>> banner();


    @GET(C.ALL_URL)
    Observable<BaseModel<GameListInfo>> all(@Path("limit") int limit,@Path("page") int page);

    @GET(C.GAME_URL)
    Observable<BaseModel<GameListInfo>> game(@Path("id") int id, @Path("limit") int limit,@Path("page") int page);

}
