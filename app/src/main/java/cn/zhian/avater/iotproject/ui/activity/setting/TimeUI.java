package cn.zhian.avater.iotproject.ui.activity.setting;

import android.util.Log;
import android.widget.LinearLayout;

import java.util.ArrayList;

import butterknife.BindView;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DataHelper;
import cn.zhian.avater.iotproject.utils.WheelViewDialog;

public class TimeUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.main)
    LinearLayout main;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.time_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.set_time)
                .build();
        findViewById(R.id.show_time).setOnClickListener(click -> {
            ArrayList<String> leftData = DataHelper.getHours12();
            ArrayList<String> middleData = DataHelper.getMinutes();
            ArrayList<String> rightData = DataHelper.getSeconds();

            WheelViewDialog wheelView = new WheelViewDialog.Builder()
                    .setContext(this)
                    .setTittle("自定义时间")
                    .setLeftData(leftData)
                    .setLeftIndex(0)
                    .setLeftListener(value -> {
                        Log.e("自定义时间", "小时 = " + value);
                    })
                    .setMiddleData(middleData)
                    .setMiddleIndex(0)
                    .setMiddleListener(value -> {
                        Log.e("自定义时间", "分钟 = " + value);
                    })
                    .setRightData(rightData)
                    .setRightIndex(0)
                    .setRightListener(value -> {
                        Log.e("自定义时间", "秒 = " + value);
                    })
                    .build();
            wheelView.show();
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
}
