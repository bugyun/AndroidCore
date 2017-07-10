package com.finupgroup.androidcore.help;

import android.content.Context;
import android.webkit.WebView;

import com.finupgroup.androidcore.BuildConfig;
import com.tencent.bugly.crashreport.CrashReport;

/**
 * Created by ruoyun on 2017/6/1.
 */

public class BuglyHelper {


    public void init(Context context) {
        CrashReport.UserStrategy strategy = new CrashReport.UserStrategy(context);
        strategy.setAppChannel("myChannel");  //设置渠道
        strategy.setAppVersion("1.0.1");      //App的版本
        strategy.setAppPackageName("com.tencent.xx");  //App的包名
        CrashReport.initCrashReport(context, "注册时申请的APPID", BuildConfig.IS_DEBUG, strategy);
        CrashReport.setIsDevelopmentDevice(context, BuildConfig.DEBUG);
    }


    /**
     * Javascript的异常捕获功能
     *
     * @param webView
     * @param autoInject
     */
    public void initJavascript(WebView webView, boolean autoInject) {
        CrashReport.setJavascriptMonitor(webView, autoInject);
    }


}
