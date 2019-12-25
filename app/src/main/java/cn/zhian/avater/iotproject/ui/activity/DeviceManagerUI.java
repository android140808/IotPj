package cn.zhian.avater.iotproject.ui.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;

public class DeviceManagerUI extends BaseUI {

    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.comm_tittle_tv_right)
    TextView commTittleTvRight;
    @BindView(R.id.recyler_view)
    RecyclerView recylerView;
    @BindView(R.id.device_rl_add)
    RelativeLayout deviceRlAdd;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.device_manager_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }


    @OnClick({R.id.comm_tittle_iv_left, R.id.comm_tittle_tv_right, R.id.device_rl_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comm_tittle_iv_left:
                closeUI();
                break;
            case R.id.comm_tittle_tv_right:
                break;
            case R.id.device_rl_add:
                changeUI(this, AddDeviceUI.class);
                break;
        }
    }
}
