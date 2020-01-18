package cn.zhian.avater.iotproject.ui.model;


import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.iotproject.base.BaseModel;
import cn.zhian.avater.iotproject.utils.LogUtil;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.utils.ServerCode;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:14
 * @Description:
 */
public class LoginModel implements BaseModel {

    public void login(String phoneNumber, String code, final CallBack callBack) {
        LoginRequest b = new LoginRequest(phoneNumber, code);
        ServerRequest.INSTANCE.login(b, false, new NetResultCallBack() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {
                if (responseCode == ServerCode.RESPONSE_SUCCESS) {
                    callBack.getCode(0);
                }
            }

            @Override
            public void onFail(int responseCode) {
                callBack.getCode(-1);
            }
        });
    }

    public void getSmsCode(String phoneNumber, final CallBack callBack) {
        LoginRequest loginRequest = new LoginRequest(phoneNumber, "");
        ServerRequest.INSTANCE.getSmsCode(loginRequest, new NetResultCallBack<BaseResponse>() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {
                LogUtil.i("LoginModel", "responseCode = " + responseCode);
                if (responseCode == ServerCode.RESPONSE_SUCCESS) {
                    MDB.INSTANCE.setCurrentPhoneNumber(phoneNumber);
                    callBack.getCode(0);
                    //todo getAllHost
                }
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
