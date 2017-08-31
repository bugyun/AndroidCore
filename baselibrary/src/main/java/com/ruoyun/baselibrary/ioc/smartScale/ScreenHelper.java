package com.ruoyun.baselibrary.ioc.smartScale;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/**
 * Created by fanpu on 2017/8/31.
 */

public class ScreenHelper {

    //    public static float applyDimension(int unit, float value,
    //                                       DisplayMetrics metrics)
    //    {
    //        switch (unit) {
    //            case COMPLEX_UNIT_PX:
    //                return value;
    //            case COMPLEX_UNIT_DIP:
    //                return value * metrics.density;
    //            case COMPLEX_UNIT_SP:
    //                return value * metrics.scaledDensity;
    //            case COMPLEX_UNIT_PT:
    //                return value * metrics.xdpi * (1.0f/72);
    //            case COMPLEX_UNIT_IN:
    //                return value * metrics.xdpi;
    //            case COMPLEX_UNIT_MM:
    //                return value * metrics.xdpi * (1.0f/25.4f);
    //        }
    //        return 0;
    //    }


    public static void help(Context context, int designWidth) {

        Point size = new Point();
        //修改屏幕density
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display defaultDisplay = wm != null ? wm.getDefaultDisplay() : null;
        if (defaultDisplay != null) {
            defaultDisplay.getSize(size);
            Configuration cfg = context.getResources().getConfiguration();
            //                displayMetrics.densityDpi = DisplayMetrics.DENSITY_MEDIUM;
            displayMetrics.xdpi = size.x / designWidth * 72f;
            //context.getResources().updateConfiguration(cfg, displayMetrics);
            //            if (displayMetrics.widthPixels == 1024 && displayMetrics.heightPixels == 600 && displayMetrics.densityDpi == DisplayMetrics.DENSITY_HIGH) {
            //                Configuration cfg = context.getResources().getConfiguration();
            //                displayMetrics.densityDpi = DisplayMetrics.DENSITY_MEDIUM;
            //                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            //                    cfg.densityDpi = DisplayMetrics.DENSITY_MEDIUM;
            //                }
            //                context.getResources().updateConfiguration(cfg, displayMetrics);
            //            }
        }
    }


    public static void helpBitMap(Context context, int width, int height) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        //        Bitmap bitmap = Bitmap.createBitmap(displayMetrics, width, height, Bitmap.Config.ARGB_8888);
        //        bitmap.setDensity(DisplayMetrics.DENSITY_MEDIUM);
    }


}
