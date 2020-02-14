package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.Switch;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class CustomSenseUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {


    @BindView(R.id.switch_table_line)
    Switch switchTableLine;
    @BindView(R.id.switch_table_line1)
    Switch switchTableLine1;
    @BindView(R.id.switch_room_line)
    Switch switchRoomLine;
    @BindView(R.id.main_tv_setting)
    RelativeLayout mainTvSetting;
    @BindView(R.id.switch_win_control)
    Switch switchWinControl;
    @BindView(R.id.switch_red_control)
    Switch switchRedControl;
    @BindView(R.id.switch_camera_control)
    Switch switchCameraControl;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.custom_sense_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.room_often)
                .setShowRightTv(true)
                .setRightRes(R.string.save)
                .setRightTvColor(R.color.home_icon_bg)
                .setRightTvListener(this)
                .build();
    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading() {

    }

    @OnClick(R.id.main_tv_setting)
    public void onViewClicked() {
        showToast("打开空调遥控器");
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onRightTvClick() {
        showToast("保存成功");
    }
}
