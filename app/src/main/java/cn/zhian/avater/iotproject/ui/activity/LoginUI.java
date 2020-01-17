package cn.zhian.avater.iotproject.ui.activity;

import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

import android.text.TextUtils;
import android.util.Log;
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
    private AlertDialog alertDialog;
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
                if (TextUtils.isEmpty(loginEtPhone.getText().toString())) {
                    showToast(R.string.login_input_phone);
                    return;
                }
                mPresenter.getCode(this, loginEtPhone.getText().toString());
                break;
            case R.id.login_btn_login:
                if (TextUtils.isEmpty(loginEtPhone.getText().toString())) {
                    showToast(R.string.login_input_phone);
                    return;
                }
                if (TextUtils.isEmpty(loginEtCode.getText().toString())) {
                    showToast(R.string.login_set_phone_check);
                    return;
                }
                if (!loginCbAgree.isChecked()) {
                    showAlert();
                    return;
                }
                mPresenter.login(this, loginEtPhone.getText().toString(), loginEtCode.getText().toString());
//                changeUI(this, MainUI.class);
//                closeUI();
                break;
            case R.id.login_cb_agree:
                if (!loginCbAgree.isChecked()) {
                    return;
                }
                showAlertTips();
                break;
        }
    }

    private void showAlertTips() {
        alertDialog = null;
        alertDialog = new AlertDialog.Builder(this)
                .setMessage(R.string.login_tips_content)
                .setPositiveButton(android.R.string.ok, okLis)
                .setNegativeButton(android.R.string.cancel, cancelLis)
                .create();
        alertDialog.setCanceledOnTouchOutside(false);
        alertDialog.setCancelable(false);
        alertDialog.show();
    }

    private void showAlert() {
        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(this)
                    .setMessage(R.string.login_agree_alert)
                    .setPositiveButton(android.R.string.ok, unSelectLis)
                    .create();
            alertDialog.setCanceledOnTouchOutside(false);
            alertDialog.setCancelable(false);
        }
        alertDialog.show();
    }

    private DialogInterface.OnClickListener unSelectLis = (dia, i) -> {
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    };
    private DialogInterface.OnClickListener okLis = (dia, i) -> {
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
        }
    };
    private DialogInterface.OnClickListener cancelLis = (dia, i) -> {
        if (alertDialog != null) {
            loginCbAgree.setChecked(!loginCbAgree.isChecked());
            alertDialog = null;
        }
    };

    @Override
    public void getCodeFromServer(String code) {
        Log.e("getCodeFromServer", "code == " + code);
    }

    @Override
    public void loginSuccess() {

    }

    @Override
    public void loginFailed(String msg) {
        showToast(msg);
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
