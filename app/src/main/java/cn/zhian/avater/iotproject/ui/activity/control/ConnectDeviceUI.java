package cn.zhian.avater.iotproject.ui.activity.control;

import android.annotation.SuppressLint;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

import androidx.annotation.NonNull;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.widget.ConnectProgress;

public class ConnectDeviceUI extends BaseUI implements TittleManager.OnLeftClickListener {

    @BindView(R.id.connect_state_view)
    ConnectProgress connectStateView;
    @BindView(R.id.state_into_host)
    ImageView stateIntoHost;
    @BindView(R.id.state_into_device)
    ImageView stateIntoDevice;
    @BindView(R.id.state_into_result)
    ImageView stateIntoResult;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    connectStateView.setProgroess(33);
                    stateIntoHost.setBackground(getDrawable(R.drawable.connect_dot_blue2));
                    mHandler.sendEmptyMessageDelayed(1, 1000);
                    break;

                case 1:
                    connectStateView.setProgroess(66);
                    stateIntoDevice.setBackground(getDrawable(R.drawable.connect_dot_blue2));
                    mHandler.sendEmptyMessageDelayed(2, 1000);
                    break;
                case 2:
                    connectStateView.setProgroess(100);
                    stateIntoResult.setBackground(getDrawable(R.mipmap.connect_success));
                    break;
            }
        }
    };

    @Override
    public int getViewLayout() {
        return R.layout.connect_device_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.connect_ing)
                .build();
    }

    @Override
    public void initData() {
        connectStateView.setBitmap(BitmapFactory.decodeResource(getResources(), R.mipmap.kx_sense));
        connectStateView.setProgroess(0);
        mHandler.sendEmptyMessageDelayed(0, 1000);
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @OnClick(R.id.state_into_result)
    public void onClick() {
        changeUI(this, LightUI.class);
    }
}
