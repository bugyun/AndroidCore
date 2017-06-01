package com.finupgroup.androidcore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.finupgroup.androidcore.test.KLogTest;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testLog();
    }

    public void testLog() {
        KLogTest kLogTest = new KLogTest();
        kLogTest.initData(this);
        kLogTest.logDebug();
        kLogTest.log();
        kLogTest.logWithFile();
        kLogTest.logWithJson();
        kLogTest.logWithJsonTag();
        kLogTest.logWithLong();
        kLogTest.logWithMsg();
        kLogTest.logWithNull();
        kLogTest.logWithLongJson();
        kLogTest.logWithXml();
        kLogTest.logWithParams();
        kLogTest.logWithTag();
    }

}
