package cn.zhian.avater.iotproject.ui.activity.control;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class SwichTypeUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {

    @BindView(R.id.switch_name)
    EditText switchName;
    @BindView(R.id.device_location)
    TextView deviceLocation;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.swich_type_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightTvClick() {

    }

    @OnClick(R.id.device_rl_add)
    public void onClick() {
    }
}
