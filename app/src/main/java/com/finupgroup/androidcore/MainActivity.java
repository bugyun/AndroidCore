package com.finupgroup.androidcore;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.finupgroup.androidcore.manager.AppManager;
import com.finupgroup.androidcore.test.KLogTest;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        testLog();

        Intent intent = getIntent();
        //通过判断Activity的数量决定是否是直接唤起页面还是先唤起主界面再打开需要打开的界面使得按返回键不至于直接从二级或者三级界面退出应用，提高用户体验。
        if (intent != null && Intent.ACTION_VIEW.equals(intent.getAction())) {
            int activitySize = AppManager.getAppManager().getSize();
            if (activitySize > 1) {
                jumpFromBrowser(intent.getData());
            } else {
                intent.setClass(this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
            finish();
            return;
        }


    }

    private void jumpFromBrowser(Uri data) {
        Intent intent = getIntent();
        if (Intent.ACTION_VIEW.equals(intent.getAction())) {
            //            Uri data = intent.getData();
            //            String id = data.getQueryParameter("id");
        }

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


    private long lastTime;

    /**
     * 拦截 Back 键，使 App 进入后台而不是关闭
     */
    @Override
    public void onBackPressed() {
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastTime < 2 * 1000) {
            Intent launcherIntent = new Intent(Intent.ACTION_MAIN);
            launcherIntent.addCategory(Intent.CATEGORY_HOME);
            startActivity(launcherIntent);
        } else {
            Toast.makeText(this, "请再按一次", Toast.LENGTH_SHORT).show();
            lastTime = currentTime;
        }
    }


    private void getScheme() {
        //判断是否是通过action_view打开方式
        if (!Intent.ACTION_VIEW.equals(getIntent().getAction())) {
            return;
        }
        Uri uri = getIntent().getData();
        if (uri != null) {
            // 完整的url信息
            String url = uri.toString();
            Log.e(TAG, "url: " + uri);
            // scheme部分
            String scheme = uri.getScheme();
            Log.e(TAG, "scheme: " + scheme);
            // host部分
            String host = uri.getHost();
            Log.e(TAG, "host: " + host);
            //port部分
            int port = uri.getPort();
            Log.e(TAG, "host: " + port);
            // 访问路劲
            String path = uri.getPath();
            Log.e(TAG, "path: " + path);
            List<String> pathSegments = uri.getPathSegments();
            // Query部分
            String query = uri.getQuery();
            Log.e(TAG, "query: " + query);
            //获取指定参数值
            String goodsId = uri.getQueryParameter("goodsId");
            Log.e(TAG, "goodsId: " + goodsId);
        }
    }


}
