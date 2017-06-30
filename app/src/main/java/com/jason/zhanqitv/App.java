package com.jason.zhanqitv;

import android.app.Application;
import android.content.Context;

/**
 * Created by Jason on 2017/6/30 0030.
 */

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

    }

    public Context getAppContext(){
        return this;
    }

}
