package cn.zhian.avater.iotproject.ui.presenter;

import android.content.Context;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.ui.model.LoginModel;
import cn.zhian.avater.iotproject.ui.view.LoginView;
import cn.zhian.avater.iotproject.utils.DataHelper;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:13
 * @Description:
 */
public class LoginPresenter implements BasePresenter {

    private LoginView view;
    private LoginModel loginModel;

    public LoginPresenter(LoginView view) {
        this.view = view;
        loginModel = new LoginModel();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    public void getCode(Context context) {
        if (view == null) {
            return;
        }
        if (!DataHelper.networkState(context)) {
            view.loginFailed(context.getResources().getString(R.string.login_network_error));
            return;
        }
    }

    public void login(Context context, String phoneNumber, String password) {
        if (!DataHelper.networkState(context)) {
            view.loginFailed(context.getResources().getString(R.string.login_network_error));
            return;
        }
        boolean state = DataHelper.isChinaPhone(phoneNumber);
        if (!state) {
            view.loginFailed(context.getResources().getString(R.string.login_phone_error));
            return;
        }

    }
}
