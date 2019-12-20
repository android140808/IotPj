package cn.zhian.avater.iotproject.ui.activity;

import android.view.KeyEvent;

import java.util.concurrent.TimeUnit;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseUI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class FlashUI extends BaseUI {


    @Override
    public int getViewLayout() {
        return R.layout.activity_flash_ui;
    }

    @Override
    public void findViewById() {
    }

    @Override
    public void initData() {
        Observable.timer(500, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                changeUI(mContext, LoginUI.class);
                closeUI();
            }
        });
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getRepeatCount() == 0) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
