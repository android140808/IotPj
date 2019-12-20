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

public class ManagerUI extends BaseUI {

    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.manager_rl_up_load)
    RelativeLayout managerRlUpLoad;
    @BindView(R.id.manager_down_load)
    RelativeLayout managerDownLoad;

    @Override
    public int getViewLayout() {
        return R.layout.manager_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.comm_tittle_iv_left, R.id.manager_rl_up_load, R.id.manager_down_load})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comm_tittle_iv_left:
                closeUI();
                break;
            case R.id.manager_rl_up_load:
                break;
            case R.id.manager_down_load:
                break;
        }
    }
}
