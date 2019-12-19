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

public class LoginUI extends BaseUI {

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

    @Override
    public int getViewLayout() {
        return R.layout.login_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.login_iv_wechat, R.id.login_tv_get, R.id.login_btn_login, R.id.login_cb_agree})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_iv_wechat:
                break;
            case R.id.login_tv_get:
                break;
            case R.id.login_btn_login:
                changeUI(this, MainUI.class);
                break;
            case R.id.login_cb_agree:
                break;
        }
    }
}
