package com.ruoyun.baselibrary.ioc;

import android.content.Context;
import android.view.ViewGroup;

import com.ruoyun.baselibrary.R;


/**
 * Created by fanpu on 2017/8/18.
 */

public class DefaultNavigationBar extends AbsNavigationBar {

    public DefaultNavigationBar(Builder.AbsNavigationParams mParams) {
        super(mParams);
    }

    @Override
    public int bingLayoutId() {
        return R.layout.title_bar;
    }

    @Override
    public void applyView() {
        getParams().mParent.findViewById(R.id.mToolbar);
    }


    public static class Builder extends AbsNavigationBar.Builder {

        DefaultNavigationParams p;

        public Builder(Context context, ViewGroup parent) {
            super(context, parent);
            p = new DefaultNavigationParams(context, parent);
        }

        public Builder(Context context) {
            super(context, null);
            p = new DefaultNavigationParams(context, null);
        }


        public Builder setTitle(String mTitle) {
            p.mTitle = mTitle;
            return this;
        }

        public Builder setRightIcon(int rightRes) {
            p.rightRes = rightRes;
            return this;
        }

        @Override
        public DefaultNavigationBar builder() {
            DefaultNavigationBar navigationBar = new DefaultNavigationBar(p);
            return navigationBar;
        }

        public static class DefaultNavigationParams extends AbsNavigationParams {

            public String mTitle;
            public int rightRes;

            public DefaultNavigationParams(Context context, ViewGroup mParent) {
                super(context, mParent);
            }
        }

    }


}
