package cn.zhian.avater.iotproject;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import cn.zhian.avater.databasemodule.DataBaseContext;
import cn.zhian.avater.netmodule.ServerContext;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 10:36
 * @Description:
 */
public class Applications extends MultiDexApplication {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mContext = this;
        ServerContext.INSTANCE.init(this);
        DataBaseContext.init(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(base);
    }

    public static Context getPowerContext() {
        return mContext;
    }
}
