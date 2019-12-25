package cn.zhian.avater.iotproject.ui.presenter;

import android.content.Context;
import android.util.Log;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseView;
import cn.zhian.avater.iotproject.ui.model.LoginModel;
import cn.zhian.avater.iotproject.ui.view.LoginView;
import cn.zhian.avater.iotproject.utils.BuglyHelp;
import cn.zhian.avater.iotproject.utils.DataHelper;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:13
 * @Description:
 */
public class LoginPresenter<V extends BaseView> implements BasePresenter<V> {

    private LoginView view;
    private LoginModel loginModel;

    public LoginPresenter() {
        loginModel = new LoginModel();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void attachView(BaseView view) {
        this.view = (LoginView) view;
    }


    public void getCode(Context context) {
        if (view == null) {
            return;
        }
        if (!DataHelper.networkState(context)) {
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
