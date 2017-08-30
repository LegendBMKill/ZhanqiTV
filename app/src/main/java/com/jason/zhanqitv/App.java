package com.jason.zhanqitv;

import android.app.Application;
import android.content.Context;

import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.FormatStrategy;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;

/**
 * Created by Jason on 2017/6/30 0030.
 */

public class App extends Application {

    private static Context mContext;
    private static final String TAG = "debug";
    @Override
    public void onCreate() {
        super.onCreate();
        mContext = this;
        initLogger(TAG);
    }

    public static Context AppContext(){
        return mContext;
    }

    private void initLogger(String tag) {
        FormatStrategy formatStrategy = PrettyFormatStrategy.newBuilder()
                .tag(tag) // 全局tag
                .showThreadInfo(false)
                .methodCount(0)
                .build();
        Logger.addLogAdapter(new AndroidLogAdapter(formatStrategy) {
            @Override
            public boolean isLoggable(int priority, String tag) {
                return true;
            }
        });
    }
}
