package cn.zhian.avater.iotproject.ui.activity.control;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class AddDetailRoomUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {

    private String tittleName = "";

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.add_detail_room_ui;
    }

    @Override
    public void findViewById() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            tittleName = bundle.getString("tittle");
        }
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleResString(tittleName)
                .setShowRightTv(true)
                .setRightTvColor(R.color.home_icon_bg)
                .setRightRes(R.string.add)
                .setRightTvListener(this)
                .build();
    }

    @Override
    public void initData() {

    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onRightTvClick() {
        changeUI(this, AddDeviceUI.class);
    }
}
