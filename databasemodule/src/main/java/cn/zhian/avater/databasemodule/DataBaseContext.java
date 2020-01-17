package cn.zhian.avater.databasemodule;

import android.content.Context;
import android.content.SharedPreferences;

import org.litepal.LitePal;

import cn.zhian.avater.databasemodule.utils.LogUtil;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-21 9:11
 * @Description:
 */
public class DataBaseContext {

    private static Context mContext;

    public static void init(Context context) {
        LitePal.initialize(context);
        mContext = context;
    }


    public static void initLogUtil(boolean state) {
        LogUtil.init(state, state);
    }

    public static Context getContent() {
        return mContext;
    }
}

