package cn.zhian.avater.iotproject;

import android.content.Context;

import androidx.multidex.MultiDex;
import androidx.multidex.MultiDexApplication;

import com.tencent.bugly.crashreport.CrashReport;

import cn.jpush.android.api.JPushInterface;
import cn.zhian.avater.databasemodule.DataBaseContext;
import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.iotproject.utils.LogUtil;
import cn.zhian.avater.iotproject.utils.NetStatesUtil;
import cn.zhian.avater.netmodule.ServerContext;
import cn.zhian.avater.netmodule.ServerVal;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 10:36
 * @Description: 要求所有可能出现异常捕获的地方，必须要向上层抛出，不能捕获了什么都不做！
 */
public class Applications extends MultiDexApplication {

    private static Context mContext;
    public static String WE_CHAT_C_K = "wxa8f51b7a8f458696";
    public static String WE_CHAT_A_K = "";

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        mContext = this;
        JPushInterface.init(this);
        JPushInterface.setDebugMode(true);
        NetStatesUtil.getNetWordState(this);
        DataBaseContext.init(this);
        ServerContext.INSTANCE.init(this);
        CrashReport.initCrashReport(this, "f9924dd2fb", false);//false 开启上报，true:开发测试，不上报
        if (BuildConfig.DEBUG) {//测试环境下打印log
            ServerContext.INSTANCE.initLogUtil(true);
            DataBaseContext.initLogUtil(true);
            LogUtil.init(true, true);
        }
    }

    private void initData() {
//        ServerVal.accessToken = MDB.INSTANCE.getAccount("").getToken();
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        //Dalvik 2.1.0 会优先进行分包处理（由手机硬件决定），其他会交由MultiDex处理。不用理会LogCat的日志输出
        MultiDex.install(this);
    }

    public static Context getPowerContext() {
        return mContext;
    }
}
