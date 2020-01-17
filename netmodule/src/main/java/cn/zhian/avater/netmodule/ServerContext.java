package cn.zhian.avater.netmodule;

import android.content.Context;

import cn.zhian.avater.netmodule.utils.LogUtil;

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

    public void initLogUtil(boolean state) {
        LogUtil.init(state, state);
    }

    public Context getContext() {
        return context;
    }}
