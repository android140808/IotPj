package cn.zhian.avater.iotproject.ui.presenter;

import android.util.Log;

import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseView;
import cn.zhian.avater.iotproject.ui.interfaces.CommCallBack;
import cn.zhian.avater.iotproject.ui.model.SettingModel;
import cn.zhian.avater.iotproject.ui.view.SettintView;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-19 8:26
 * @Description:
 */
public class SettingPresenter<V extends BaseView> implements BasePresenter<V> {

    private SettintView view;
    private SettingModel model;

    public SettingPresenter() {
        this.model = new SettingModel();
    }

    @Override
    public void onDestroy() {
        view = null;
    }

    @Override
    public void attachView(V view) {
        this.view = (SettintView) view;
    }

    public void logout() {
        model.logout(code -> {
            if (view != null) {
                if (code >= 0) {
                    view.logoutState(true);
                } else {
                    view.logoutState(false);
                }
            }
        });
    }
}
