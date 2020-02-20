package cn.zhian.avater.iotproject.ui.activity.setting;

import android.view.View;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class PasswordUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.pass_word_rl_change)
    RelativeLayout passWordRlChange;
    @BindView(R.id.pass_word_rl_limit_manager)
    RelativeLayout passWordRlLimitManager;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.password_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.setting_password)
                .build();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.pass_word_rl_change, R.id.pass_word_rl_limit_manager})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.pass_word_rl_change:
                changeUI(this, ChangePassUI.class);
                break;
            case R.id.pass_word_rl_limit_manager:
                break;
        }
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
