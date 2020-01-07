package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class ManagerUI extends BaseUI implements TittleManager.OnLeftClickListener {

    @BindView(R.id.manager_rl_up_load)
    RelativeLayout managerRlUpLoad;
    @BindView(R.id.manager_down_load)
    RelativeLayout managerDownLoad;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.manager_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.setting_manager)
                .build();
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.manager_rl_up_load, R.id.manager_down_load})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.manager_rl_up_load:
                break;
            case R.id.manager_down_load:
                break;
        }
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
