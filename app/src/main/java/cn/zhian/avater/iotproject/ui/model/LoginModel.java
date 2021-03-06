package cn.zhian.avater.iotproject.ui.model;


import android.text.TextUtils;

import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.iotproject.base.BaseModel;
import cn.zhian.avater.iotproject.utils.LogUtil;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.ServerVal;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.LoginHeaders;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;
import cn.zhian.avater.netmodule.utils.ServerCode;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:14
 * @Description:
 */
public class LoginModel implements BaseModel {

    public void loginWithSmsCode(String phoneNumber, String code, final CommCallBack callBack, LoginHeaders headers) {
        LoginRequest request = new LoginRequest(phoneNumber, code);
        ServerRequest.INSTANCE.loginWithSmsCode(request, new NetResultCallBack<LoginResponse>() {
            @Override
            public void onSuccess(int responseCode, LoginResponse baseResponse) {
                if (responseCode == ServerCode.RESPONSE_SUCCESS) {
                    MDB.INSTANCE.setCurrentPhoneNumber(phoneNumber);
                    String token = baseResponse.data.token;
                    ServerVal.accessToken = token;
                    LogUtil.e("LoginModel", "phoneNumber = " + phoneNumber);
                    LogUtil.e("LoginModel", "token = " + token);
                    if (!TextUtils.isEmpty(token)) {
                        MDB.INSTANCE.setToken(token);
                    }
                    callBack.state(0);
                }
            }

            @Override
            public void onFail(int responseCode) {
                callBack.state(-1);
            }
        }, headers);
    }

    public void getSmsCode(String phoneNumber, final CommCallBack callBack) {
        LoginRequest loginRequest = new LoginRequest(phoneNumber, "");
        ServerRequest.INSTANCE.getSmsCode(loginRequest, new NetResultCallBack<BaseResponse>() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {
                LogUtil.i("LoginModel", "responseCode = " + responseCode);
                if (responseCode == ServerCode.RESPONSE_SUCCESS) {
                    callBack.state(0);
                }
            }

            @Override
            public void onFail(int responseCode) {
                LogUtil.i("LoginModel", "responseCode = " + responseCode);
                callBack.state(-1);
            }
        });
    }


}
