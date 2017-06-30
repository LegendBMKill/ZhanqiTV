package com.jason.zhanqitv.http;

import com.jason.zhanqitv.constants.C;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jason on 2017/6/30 0030.
 */

public class RetrofitApi {

    private volatile static Retrofit retrofit = null;

    private static final int TIME_OUT = 10;


    private static void init(){
        if (null==retrofit){
            synchronized (RetrofitApi.class){
                if (null == retrofit){
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    LoggerHttpInterceptor interceptor = new LoggerHttpInterceptor();
                    builder.addInterceptor(interceptor);

                    OkHttpClient client = builder
                            .connectTimeout(TIME_OUT, TimeUnit.SECONDS)
                            .readTimeout(TIME_OUT,TimeUnit.SECONDS)
                            .writeTimeout(TIME_OUT,TimeUnit.SECONDS)
                            .build();

                    retrofit = new Retrofit.Builder()
                            .baseUrl(C.BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .build();
                }
            }
        }
    }

    public static <T>T create(final Class<T> service){
        if (retrofit==null){
            init();
        }
        return retrofit.create(service);
    }
}
