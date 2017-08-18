package com.ruoyun.baselibrary.ioc;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by fanpu on 2017/8/18.
 * 头部builder的基类
 */

public abstract class AbsNavigationBar implements INavigationBar {


    private Builder.AbsNavigationParams mParams;

    public AbsNavigationBar(Builder.AbsNavigationParams mParams) {
        this.mParams = mParams;
        createAndBindView();
    }

    private void createAndBindView() {
        if (null == mParams.mParent) {
            ViewGroup activityRoot = ((Activity) mParams.context).findViewById(android.R.id.content);
            mParams.mParent = (ViewGroup) activityRoot.getChildAt(0);
        }
        //create view
        View navigationView = LayoutInflater.from(mParams.context).inflate(bingLayoutId(), mParams.mParent, false);
        //addView
        mParams.mParent.addView(navigationView, 0);
    }

    public Builder.AbsNavigationParams getParams() {
        return mParams;
    }

    public abstract static class Builder {

        AbsNavigationParams params;


        public Builder(Context context, ViewGroup parent) {
            params = new AbsNavigationParams(context, parent);
        }

        public abstract AbsNavigationBar builder();


        public static class AbsNavigationParams {

            protected Context context;

            protected ViewGroup mParent;

            public AbsNavigationParams(Context context, ViewGroup mParent) {
                this.context = context;
                this.mParent = mParent;
            }
        }


    }
}

