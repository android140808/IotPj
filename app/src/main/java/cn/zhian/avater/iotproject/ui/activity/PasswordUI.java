package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseUI;

public class PasswordUI extends BaseUI {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.pass_word_rl_change)
    RelativeLayout passWordRlChange;
    @BindView(R.id.pass_word_rl_limit_manager)
    RelativeLayout passWordRlLimitManager;

    @Override
    public int getViewLayout() {
        return R.layout.password_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.comm_tittle_iv_left, R.id.pass_word_rl_change, R.id.pass_word_rl_limit_manager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comm_tittle_iv_left:
                closeUI();
                break;
            case R.id.pass_word_rl_change:
                break;
            case R.id.pass_word_rl_limit_manager:
                break;
        }
    }
}
