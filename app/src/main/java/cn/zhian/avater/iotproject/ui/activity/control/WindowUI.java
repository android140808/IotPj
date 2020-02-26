package cn.zhian.avater.iotproject.ui.activity.control;

import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;

public class WindowUI extends BaseUI {


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.window_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back, R.id.edit, R.id.ll_open, R.id.ll_stop, R.id.ll_close})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                closeUI();
                break;
            case R.id.edit:
                break;
            case R.id.ll_open:
                break;
            case R.id.ll_stop:
                break;
            case R.id.ll_close:
                break;
        }
    }
}
