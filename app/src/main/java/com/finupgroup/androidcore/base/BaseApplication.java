package com.finupgroup.androidcore.base;

import android.app.Application;
import android.content.res.Configuration;
import android.graphics.Point;
import android.view.WindowManager;

import com.finupgroup.androidcore.BuildConfig;
import com.socks.library.KLog;

/**
 * Created by ruoyun on 2017/6/1.
 */

public class BaseApplication extends Application {

    public final static float DESIGN_WIDTH = 750;


    @Override
    public void onCreate() {
        super.onCreate();
        KLog.init(BuildConfig.IS_DEBUG, "zyh");
        resetDensity();
    }

    private void resetDensity() {
        Point size = new Point();
        ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay().getSize(size);
        getResources().getDisplayMetrics().xdpi = size.x / DESIGN_WIDTH * 72f;
        KLog.e("zyh", getResources().getDisplayMetrics().toString());
        //[ (BaseApplication.java:31)#resetDensity ] DisplayMetrics{density=2.0, width=720, height=1280, scaledDensity=2.0, xdpi=69.119995, ydpi=295.563}
    }


    /**
     * density:
     * 显示屏的逻辑密度。这是一个缩放因子
     * 密度独立像素单位，其中一个DIP是一个像素
     * 约160dpi屏幕（例如240×320,1.5“×2”屏幕），
     * 提供系统显示的基线。因此在160dpi屏幕上
     * 该密度值将为1;在120 dpi屏幕上将是.75;等等
     * 该值并不完全遵循实际的屏幕尺寸（如由
     * {@link #xdpi}和{@link #ydpi}，而是用来缩放大小
     * 基于显示dpi的总体变化的整体UI。对于
     * 例如，即使宽度为240x320，屏幕的密度将为1
     * 1.8“，1.3”等。但是，如果屏幕分辨率增加到
     * 320x480但是屏幕尺寸保持在1.5“x2”，那么密度就是这样
     * 增加（可能到1.5）。
     * <p>
     * <p>
     * widthPixels：
     * 可用显示尺寸的绝对宽度，以像素为单位。
     * <p>
     * heightPixels：
     * 可用显示尺寸的绝对高度（以像素为单位）
     * <p>
     * scaledDensity
     * <p>
     * 显示屏上显示的字体的缩放因子。这是一样的
     * 作为{@link #density}，除了它可能被调整为较小
     * 基于字体大小的用户偏好，运行时增量。
     * <p>
     * <p>
     * X维度中屏幕每英寸的精确物理像素
     */

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetDensity();
    }
}
