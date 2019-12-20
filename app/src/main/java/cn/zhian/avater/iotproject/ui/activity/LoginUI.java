package cn.zhian.avater.iotproject.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.presenter.LoginPresenter;
import cn.zhian.avater.iotproject.ui.view.LoginView;
import cn.zhian.avater.iotproject.utils.PermissionUtils;

public class LoginUI extends BaseUI implements LoginView {

    @BindView(R.id.login_iv_wechat)
    ImageView loginIvWechat;

    @BindView(R.id.bottom)
    LinearLayout bottom;
    @BindView(R.id.login_et_phone)
    EditText loginEtPhone;
    @BindView(R.id.login_tv_get)
    TextView loginTvGet;
    @BindView(R.id.login_btn_login)
    Button loginBtnLogin;
    @BindView(R.id.login_cb_agree)
    CheckBox loginCbAgree;
    private LoginPresenter presenter;

    @Override
    public int getViewLayout() {
        return R.layout.login_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {
        presenter = new LoginPresenter(this);
        PermissionUtils.getInstance().applyAllPermissions(this);
    }


    @OnClick({R.id.login_iv_wechat, R.id.login_tv_get, R.id.login_btn_login, R.id.login_cb_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_iv_wechat:
                break;
            case R.id.login_tv_get:
                presenter.getCode(LoginUI.this);
                break;
            case R.id.login_btn_login:
                changeUI(this, MainUI.class);
                closeUI();
                break;
            case R.id.login_cb_agree:
                break;
        }
    }

    @Override
    public void getCodeFromServer(String code) {

    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed(String msg) {
        showToast(msg);
    }

    @Override
    public void networkError() {

    }
}
