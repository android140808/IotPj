package cn.zhian.avater.iotproject.ui.model;


import android.os.Handler;

import cn.zhian.avater.iotproject.base.BaseModel;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:14
 * @Description:
 */
public class LoginModel implements BaseModel {

    public void login() {
    }

    public void getCode(CallBack callBack) throws Exception {
        new Handler().postDelayed(() -> {
            callBack.getCode(123456);
        }, 3000);

    }

    public static interface CallBack {
        void getCode(int code);
    }

}
