package cn.zhian.avater.iotproject.ui.model;


import android.os.Handler;

import cn.zhian.avater.iotproject.base.BaseModel;
import cn.zhian.avater.iotproject.utils.LogUtil;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:14
 * @Description:
 */
public class LoginModel implements BaseModel {

    public void login(String phoneNumber, String code) {
        LoginRequest b = new LoginRequest(phoneNumber, code);
        ServerRequest.INSTANCE.login(b, true, new NetResultCallBack() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {

            }

            @Override
            public void onFail(int responseCode) {

            }
        });
    }

    public void getSmsCode(String phoneNumber, final CallBack callBack) {
        LoginRequest b = new LoginRequest(phoneNumber, "");
        ServerRequest.INSTANCE.getSmsCode(b, new NetResultCallBack<BaseResponse>() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {
                LogUtil.i("LoginModel", "responseCode = " + responseCode);
                callBack.getCode(0);
            }

            @Override
            public void onFail(int responseCode) {
                LogUtil.i("LoginModel", "responseCode = " + responseCode);
                callBack.getCode(-1);
            }
        });
    }

    public void getAllHost(CallBack callBack) {

    }

    public interface CallBack {
        void getCode(int code);
    }

}
