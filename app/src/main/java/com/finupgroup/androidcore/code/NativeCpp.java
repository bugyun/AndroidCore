package com.finupgroup.androidcore.code;

/**
 * Created by ruoyun on 2017/5/24.
 */

public class NativeCpp {

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }


    public void test() {
        NativeCpp nativeCpp = new NativeCpp();
        // Example of a call to a native method
//        TextView tv = (TextView) findViewById(R.id.sample_text);
//        tv.setText(nativeCpp.stringFromJNI());
    }


}
