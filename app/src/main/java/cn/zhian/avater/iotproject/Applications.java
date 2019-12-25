package cn.zhian.avater.iotproject;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.crashreport.BuglyLog;
import com.tencent.bugly.crashreport.CrashReport;

import cn.zhian.avater.databasemodule.DataBaseContext;
import cn.zhian.avater.netmodule.ServerContext;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 10:36
 * @Description: 要求所有可能出现异常捕获的地方，必须要向上层抛出，不能捕获了什么都不做！
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
//        CrashReport.initCrashReport(this, "f9924dd2fb", BuildConfig.IS_DEBUG);
        CrashReport.initCrashReport(this, "f9924dd2fb", false);//false 开启上报，true:开发测试，不上报
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
