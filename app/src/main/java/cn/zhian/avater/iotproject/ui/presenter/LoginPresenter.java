package cn.zhian.avater.iotproject.ui.presenter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import cn.zhian.avater.iotproject.BuildConfig;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseView;
import cn.zhian.avater.iotproject.ui.model.LoginModel;
import cn.zhian.avater.iotproject.ui.view.LoginView;
import cn.zhian.avater.iotproject.utils.BuglyHelp;
import cn.zhian.avater.iotproject.utils.DataHelper;
import cn.zhian.avater.iotproject.utils.GeneralMethods;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseRequest;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.LoginRequest;
import cn.zhian.avater.netmodule.mode.responseBean.LoginResponse;
import cn.zhian.avater.netmodule.utils.ServerRequestManager;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:13
 * @Description:
 */
public class LoginPresenter<V extends BaseView> implements BasePresenter<V> {

    private LoginView view;
    private LoginModel loginModel;
    private String seq;

    public LoginPresenter() {
        loginModel = new LoginModel();
    }

    @Override
    public void onDestroy() {
        if (!TextUtils.isEmpty(seq)) {
            ServerRequestManager.INSTANCE.remove(seq);
        }
        view = null;
    }

    @Override
    public void attachView(BaseView view) {
        this.view = (LoginView) view;
    }


    public void getCode(Context context) {
        if (null == view) {
            return;
        }
        if (!GeneralMethods.networkState(context)) {
            view.loginFailed(context.getResources().getString(R.string.login_network_error));
            return;
        }
        try {
            loginModel.getCode(code -> {
                if (view != null) {
                    view.getCodeFromServer(code + "");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
            BuglyHelp.reportE(e, Thread.currentThread());
        }
    }

    public void login(Context context, String phoneNumber, String code) {
        if (!GeneralMethods.networkState(context)) {
            view.loginFailed(context.getResources().getString(R.string.login_network_error));
            return;
        }
        boolean state = GeneralMethods.judgeChinePhoneNumber(phoneNumber);
        if (!state) {
            view.loginFailed(context.getResources().getString(R.string.login_phone_error));
            return;
        }
        LoginRequest b = new LoginRequest(phoneNumber, code);
        seq = b.seq;
        ServerRequest.INSTANCE.login(b, true, new NetResultCallBack<LoginResponse>() {
            @Override
            public void onSuccess(int responseCode, LoginResponse baseResponse) {
                //TODO 保存TOKEN相关的数据，并获取相关的数据
                if (view != null) {
                    view.loginSuccess();
                }
            }

            @Override
            public void onFail(int responseCode) {
                if (view != null) {
                    view.loginFailed("" + responseCode);
                }
            }
        });
    }
}
