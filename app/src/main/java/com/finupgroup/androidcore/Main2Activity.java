package com.finupgroup.androidcore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ruoyun.baselibrary.ioc.DefaultNavigationBar;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        DefaultNavigationBar navigationBar = new DefaultNavigationBar.Builder(this)//
                .setTitle("nihao")//
                .builder();


    }

}
