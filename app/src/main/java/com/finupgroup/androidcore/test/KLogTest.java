package com.finupgroup.androidcore.test;

import android.content.Context;
import android.os.Environment;

import com.finupgroup.androidcore.R;
import com.socks.library.KLog;

/**
 * Created by ruoyun on 2017/6/1.
 */

public class KLogTest {


    private static final String LOG_MSG = "KLog is a so cool Log Tool!";
    private static final String TAG = "KLog";
    private static final String URL_XML = "https://raw.githubusercontent.com/ZhaoKaiQiang/KLog/master/app/src/main/AndroidManifest.xml";
    private static String XML = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?><!--  Copyright w3school.com.cn --><note><to>George</to><from>John</from><heading>Reminder</heading><body>Don't forget the meeting!</body></note>";
    private static String JSON;
    private static String JSON_LONG;
    private static String STRING_LONG;


    public void initData(Context context) {
        JSON_LONG = context.getResources().getString(R.string.json_long);
        JSON = context.getResources().getString(R.string.json);
        STRING_LONG = context.getString(R.string.string_long);
    }

    public void logDebug() {
        KLog.debug();
        KLog.debug("This is a debug message");
        KLog.debug("DEBUG", "params1", "params2", this);
    }

    public void log() {
        KLog.v();
        KLog.d();
        KLog.i();
        KLog.w();
        KLog.e();
        KLog.a();
    }

    public void logWithNull() {
        KLog.v(null);
        KLog.d(null);
        KLog.i(null);
        KLog.w(null);
        KLog.e(null);
        KLog.a(null);
    }

    public void logWithMsg() {
        KLog.v(LOG_MSG);
        KLog.d(LOG_MSG);
        KLog.i(LOG_MSG);
        KLog.w(LOG_MSG);
        KLog.e(LOG_MSG);
        KLog.a(LOG_MSG);
    }

    public void logWithTag() {
        KLog.v(TAG, LOG_MSG);
        KLog.d(TAG, LOG_MSG);
        KLog.i(TAG, LOG_MSG);
        KLog.w(TAG, LOG_MSG);
        KLog.e(TAG, LOG_MSG);
        KLog.a(TAG, LOG_MSG);
    }

    public void logWithLong() {
        KLog.d(TAG, STRING_LONG);
    }

    public void logWithParams() {
        KLog.v(TAG, LOG_MSG, "params1", "params2", this);
        KLog.d(TAG, LOG_MSG, "params1", "params2", this);
        KLog.i(TAG, LOG_MSG, "params1", "params2", this);
        KLog.w(TAG, LOG_MSG, "params1", "params2", this);
        KLog.e(TAG, LOG_MSG, "params1", "params2", this);
        KLog.a(TAG, LOG_MSG, "params1", "params2", this);
    }


    public void logWithJson() {
        KLog.json("12345");
        KLog.json(null);
        KLog.json(JSON);
    }

    public void logWithLongJson() {
        KLog.json(JSON_LONG);
    }

    public void logWithJsonTag() {
        KLog.json(TAG, JSON);
    }

    public void logWithFile() {
        KLog.file(Environment.getExternalStorageDirectory(), JSON_LONG);
        KLog.file(TAG, Environment.getExternalStorageDirectory(), JSON_LONG);
        KLog.file(TAG, Environment.getExternalStorageDirectory(), "test.txt", JSON_LONG);
    }

    public void logWithXml() {
        KLog.xml("12345");
        KLog.xml(null);
        KLog.xml(XML);
    }


}
