package cn.zhian.avater.iotproject.ui.activity.home;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class VideoWatchUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.video_watch_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setShowMiddle(true)
                .setMiddleRes(R.string.video_add)
                .setLeftListener(this)
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
}
