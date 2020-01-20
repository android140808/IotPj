package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class EnvirmentUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightIvClickListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.envirment_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setShowMiddle(true)
                .setMiddleRes(R.string.main_environment_monitor)
                .setShowRightIv(true)
                .setRightIcon(R.mipmap.setting_iv_refresh)
                .setLeftListener(this)
                .setRightIvListener(this)
                .build();
    }

    @Override
    public void showLoading() {

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
        showToast("刷新成功");
    }
}
