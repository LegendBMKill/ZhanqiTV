package com.jason.zhanqitv.http;

import com.jason.zhanqitv.constants.C;
import com.orhanobut.logger.Logger;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
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
        if (retrofit == null) {
            synchronized (RetrofitApi.class) {
                if (retrofit == null) {
//                    Timber.d(" ===== Retrofit Init   ======");
                    OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    HttpLoggingInterceptor intc = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {

                            Logger.d(message);
                            if (message.startsWith("{")||message.startsWith("--> G")||message.startsWith("--> P")){
                            }
                        }
                    });

                    intc.setLevel(HttpLoggingInterceptor.Level.BODY);
                    builder.addInterceptor(intc);
//                    builder.addInterceptor(new HeaderInterceptor());

                    OkHttpClient okhttp3 = builder
                            .connectTimeout(30_000,  TimeUnit.MILLISECONDS)
                            .readTimeout(30_000, TimeUnit.MILLISECONDS)
                            .build();

                    retrofit = new Retrofit.Builder()
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .baseUrl(C.BASE_URL)
                            .client(okhttp3)
                            .validateEagerly(true)
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
