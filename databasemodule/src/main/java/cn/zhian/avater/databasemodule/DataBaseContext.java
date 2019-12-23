package cn.zhian.avater.databasemodule;

import android.content.Context;

import org.litepal.LitePal;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-21 9:11
 * @Description:
 */
public class DataBaseContext {
    public static void init(Context context) {
        LitePal.initialize(context);
    }
}
