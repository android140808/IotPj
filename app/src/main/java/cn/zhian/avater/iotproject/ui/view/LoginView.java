package cn.zhian.avater.iotproject.ui.view;

import cn.zhian.avater.iotproject.base.BaseView;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-20 14:16
 * @Description:
 */
public interface LoginView extends BaseView {

    void showProgress();

    void loginSuccess();

    void loginFailed(String msg);

    void getSmsCode();

}
