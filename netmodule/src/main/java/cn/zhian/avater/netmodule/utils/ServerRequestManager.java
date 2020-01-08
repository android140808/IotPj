package cn.zhian.avater.netmodule.utils;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

import rx.Subscription;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-08 10:36
 * @Description:
 */
public enum ServerRequestManager {
    INSTANCE;
    private static final String TAG = ServerRequestManager.class.getName();
    private Map<String, Object> callMaps;
    private int totalCounts = 0;

    ServerRequestManager() {
        callMaps = new HashMap<>();
    }

    public synchronized void add(String key, Object call) {
        callMaps.put(key, call);
        Log.d(TAG, "新增一条请求(" + callMaps.size() + "/" + ++totalCounts + ") : " + key);
    }

    public synchronized void remove(String key) {
        if (callMaps.containsKey(key)) {
            callMaps.remove(key);
            Log.e(TAG, "删除一条请求(" + callMaps.size() + ") : " + key);
        }
    }

    public synchronized void cancelRequest(String key) {
        Log.w(TAG, "取消一条请求 : " + key);
        if (callMaps.containsKey(key)) {
            cancel(key, callMaps.remove(key));
        }
    }


    public synchronized void cancelAllRequest() {
        Log.w(TAG, "取消所有请求！！！");
        if (callMaps.size() > 0) {
            for (Map.Entry<String, Object> keyValue : callMaps.entrySet()) {
                cancel(keyValue.getKey(), keyValue.getValue());
            }
            callMaps.clear();
        }
    }

    private synchronized void cancel(String key, Object object) {
        if (object != null) {
            if (object instanceof Subscription) {
                Log.i(TAG, "------遍历取消请求 : " + key);
                Subscription subscription = (Subscription) object;
                if (!subscription.isUnsubscribed()) {
                    subscription.unsubscribe();
                }
            }
        }
    }

}
