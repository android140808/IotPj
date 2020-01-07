package cn.zhian.avater.iotproject.ui.activity;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class PersonUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightIvClickListener {


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.person_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.setting_personal)
                .setShowRightIv(true)
                .setRightIcon(R.mipmap.tittle_gou)
                .setRightIvListener(this)
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
    public void onRightIvClick() {
        showToast("ok!!");
    }
}
