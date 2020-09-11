package com.didichuxing.tools.test;

import android.app.Application;
import android.content.Context;

/**
 * @author wupuquan
 * @date 2020/9/11 13:10
 */
public class TestApp extends Application {

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }

    @Override
    public void onCreate() {
        super.onCreate();

        GlobalContext.setApplication(this);
    }
}
