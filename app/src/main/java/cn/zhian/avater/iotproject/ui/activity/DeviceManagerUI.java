package cn.zhian.avater.iotproject.ui.activity;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class DeviceManagerUI extends BaseUI implements TittleManager.OnLeftClickListener{

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
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.setting_connect)
                .build();
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.device_rl_add})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.device_rl_add:
//                changeUI(this, AddDeviceUI.class);
                changeUI(this, AddHostUI.class);
                break;
        }
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
