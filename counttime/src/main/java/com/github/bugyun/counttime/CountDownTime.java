package com.github.bugyun.counttime;


import android.os.CountDownTimer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by fanpu on 2017/7/10.
 */

public class CountDownTime {

    private static final CountDownTime mInstance = new CountDownTime();

    private List<Watcher> objectList = new ArrayList<>();//保存外部通知对象
    private HashMap<String, CountDownTimer> timerHashMap = new HashMap<>();//timer对象

    static CountDownTime getInstance() {
        return mInstance;
    }

    private CountDownTime() {
    }


    public void startWatcher(final Watcher object) {
        objectList.add(object);
        if (!timerHashMap.containsKey(object.getName())) {
            timerHashMap.put(object.getName(), new CountDownTimer(1000, 100) {

                @Override
                public void onTick(long l) {
                    if (objectList.contains(object)) {
                        object.update(l);
                    }
                }

                @Override
                public void onFinish() {
                    if (objectList.contains(object)) {
                        object.update(0);
                        objectList.remove(object);
                        timerHashMap.remove(object.getName());
                    }
                }

            });
        }
    }

    public void removeWatcher(Watcher object) {
        if (objectList.contains(object)) {
            objectList.remove(object);
        }
    }

    public void stopWatcher(Watcher watcher) {
        if (objectList.contains(watcher)) {
            objectList.remove(watcher);
        }
        if (timerHashMap.containsKey(watcher.getName())) {
            CountDownTimer countDownTimer = timerHashMap.get(watcher.getName());
            countDownTimer.cancel();
        }
    }

    public interface Watcher {
        /**
         * 通知操作
         */
        void update(long time);

        /**
         * 作为唯一标示，如果有一样如果之前存在，那么就继承之前的信息
         */
        String getName();
    }


}
