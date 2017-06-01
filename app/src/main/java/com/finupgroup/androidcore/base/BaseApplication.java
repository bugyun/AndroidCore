package com.finupgroup.androidcore.base;

import android.app.Application;

import com.finupgroup.androidcore.BuildConfig;
import com.socks.library.KLog;

/**
 * Created by ruoyun on 2017/6/1.
 */

public class BaseApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.LOG_DEBUG, "zyh");
    }
}
