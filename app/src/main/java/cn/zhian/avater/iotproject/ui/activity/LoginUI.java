package cn.zhian.avater.iotproject.ui.activity;

import android.content.DialogInterface;


import android.os.Handler;
import android.view.KeyEvent;
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
import cn.zhian.avater.iotproject.utils.DialogUtils;
import cn.zhian.avater.iotproject.utils.GeneralMethods;
import cn.zhian.avater.iotproject.utils.PermissionUtils;

public class LoginUI extends BaseUI<LoginView, LoginPresenter<LoginView>> implements LoginView {

    @BindView(R.id.login_iv_wechat)
    ImageView loginIvWechat;
    @BindView(R.id.bottom)
    LinearLayout bottom;
    @BindView(R.id.login_et_phone)
    EditText loginEtPhone;
    @BindView(R.id.login_et_code)
    EditText loginEtCode;
    @BindView(R.id.login_tv_get)
    TextView loginTvGet;
    @BindView(R.id.login_btn_login)
    Button loginBtnLogin;
    @BindView(R.id.login_cb_agree)
    CheckBox loginCbAgree;
    private long mExistTimes;


    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.login_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {
        PermissionUtils.getInstance().applyAllPermissions(this);
    }


    @OnClick({R.id.login_iv_wechat, R.id.login_tv_get, R.id.login_btn_login, R.id.login_cb_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_iv_wechat:
                mPresenter.loginWithWeChat(this);
                break;
            case R.id.login_tv_get:
                mPresenter.getSmsCode(this, loginEtPhone.getText().toString(), loginTvGet);
                break;
            case R.id.login_btn_login:
//                if (!loginCbAgree.isChecked()) {
//                    showAlert();
//                    return;
//                }
//                mPresenter.loginWithSmsCode(this, loginEtPhone.getText().toString(), loginEtCode.getText().toString());
                changeUI(this, MainUI.class);
                break;
            case R.id.login_cb_agree:
                if (!loginCbAgree.isChecked()) {
                    return;
                }
                showAlertTips();
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    private void showAlertTips() {
        alertDialog = DialogUtils.getAgreeTipDialog(this, okLis, cancelLis);
        alertDialog.show();
    }

    private void showAlert() {
        alertDialog = DialogUtils.getAgreeDialog(this, unSelectLis);
        alertDialog.show();
    }

    private void showProgressAlert() {
        alertDialog = DialogUtils.getLoadDialog(this);
        alertDialog.show();
    }

    private DialogInterface.OnClickListener unSelectLis = (dia, i) -> alertDialog.dismiss();
    private DialogInterface.OnClickListener okLis = (dia, i) -> alertDialog.dismiss();
    private DialogInterface.OnClickListener cancelLis = (dia, i) -> loginCbAgree.setChecked(!loginCbAgree.isChecked());

    @Override
    public void getSmsCode() {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        showToast(R.string.login_sms_code_tips);
        loginEtCode.setText("1234");
    }

    @Override
    public void showProgress() {
        showProgressAlert();
    }

    @Override
    public void loginSuccess() {
        new Handler().postDelayed(() -> {
            if (alertDialog != null) {
                alertDialog.dismiss();
            }
            showToast(R.string.login_success);
            changeUI(this, MainUI.class);
            closeUI();//注意rx内存泄漏问题
        }, 2000);
    }

    @Override
    public void loginFailed(String msg) {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        showToast(msg);
        mPresenter.loginFail();
        loginTvGet.setEnabled(true);
        loginTvGet.setText("获取验证码");
    }


    @Override
    public void onDestroyPresenter() {
        super.onDestroyPresenter();
        alertDialog = null;
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!GeneralMethods.existApps(mExistTimes)) {
                showToast(R.string.exist);
                mExistTimes = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
