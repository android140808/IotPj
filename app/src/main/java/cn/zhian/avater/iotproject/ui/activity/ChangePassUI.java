package cn.zhian.avater.iotproject.ui.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class ChangePassUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.change_pass_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.pass_word_change)
                .setShowRightTv(true)
                .setRightTvColor(R.color.home_icon_bg)
                .setRightTvListener(this)
                .setRightRes(R.string.save)
                .build();
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
    public void onRightTvClick() {
        showToast("添加成功");
    }
}
