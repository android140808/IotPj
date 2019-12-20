package cn.zhian.avater.netmodule;

import android.content.Context;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 16:08
 * @Description:
 */
public enum ServerContext {
    INSTANCE;

    private Context context;

    public void init(Context context) {
        this.context = context;
    }

    public Context getContext() {
        return context;
    }}
