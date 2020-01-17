package cn.zhian.avater.iotproject.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;


import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-13 10:38
 * @Description:
 */
public class NetStatesUtil {

    public static State mCurrentState = State.NET_MOBILE;
    private static String TAG = NetStatesUtil.class.getSimpleName();

    /**
     * 10s 自动检查一次网络状态
     *
     * @param context
     */
    public static void getNetWordState(Context context) {
        Observable.interval(10, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(aLong -> {
                    ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
                    NetworkInfo info = manager.getActiveNetworkInfo();
                    if (info != null && info.isConnected()) {
                        int type = info.getType();
                        switch (type) {
                            case ConnectivityManager.TYPE_WIFI:
                                mCurrentState = State.NET_WIFI;
                                break;
                            case ConnectivityManager.TYPE_MOBILE:
                                mCurrentState = State.NET_MOBILE;
                                break;
                            default:
                                mCurrentState = State.NET_NONE;
                                Log.e(TAG, "当前网络为： 无网络连接");
                                break;
                        }

                    } else {//把wifi 移动网络 都关闭时
                        mCurrentState = State.NET_NONE;
                        Log.e(TAG, "当前网络为： 无网络连接");
                    }
                });
    }


    public enum State {
        NET_MOBILE,//移动数据网络
        NET_WIFI,//无线WIFI
        NET_NONE,//无网络
    }
}
