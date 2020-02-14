package cn.zhian.avater.iotproject.ui.activity;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

/**
 * 四种建议的情景模式
 * currentType 0离家模式，1回家模式，2安全模式，3睡眠模式
 */
public class Sense4TypeUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightIvClickListener {

    int currentType = 0;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.sense4_type_ui;
    }

    @Override
    public void findViewById() {
        currentType = getIntent().getExtras().getInt("type", 0);
        int tittle = R.string.main_scenes_leave_home;
        switch (currentType) {
            case 0:
                tittle = R.string.main_scenes_leave_home;
                break;
            case 1:
                tittle = R.string.main_scenes_go_home;
                break;
            case 2:
                tittle = R.string.main_scenes_safe;
                break;
            case 3:
                tittle = R.string.main_scenes_sleep;
                break;
        }
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(tittle)
                .setShowRightIv(true)
                .setRightIcon(R.mipmap.add)
                .setRightIvListener(this)
                .build();

        findViewById(R.id.time).setOnClickListener(click -> {
            changeUI(Sense4TypeUI.this, TimeUI.class);
        });
    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onRightIvClick() {
        showToast("保存");
    }
}
