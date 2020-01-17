package cn.zhian.avater.iotproject.ui.activity;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.widget.TextView;

import java.util.concurrent.TimeUnit;

import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;

public class FlashUI extends BaseUI {


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.flash_ui;
    }

    @Override
    public void findViewById() {
    }

    @Override
    public void initData() {
        Observable.timer(3000, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                if (!TextUtils.isEmpty(mCurrentPhoneNumber)) {//没有登录的操作
                    changeUI(mContext, MainUI.class);
                } else {//已经登录
                    changeUI(mContext, LoginUI.class);
                }
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
