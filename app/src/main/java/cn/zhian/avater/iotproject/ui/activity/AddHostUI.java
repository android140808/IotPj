package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.zxing.android.CaptureActivity;

public class AddHostUI extends BaseUI {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.ll_qr_code)
    LinearLayout llQrCode;
    @BindView(R.id.ll_by_hand)
    LinearLayout llByHand;
    @BindView(R.id.ll_by_net)
    LinearLayout llByNet;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.add_host_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.comm_tittle_iv_left, R.id.ll_qr_code, R.id.ll_by_hand, R.id.ll_by_net})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comm_tittle_iv_left:
                closeUI();
                break;
            case R.id.ll_qr_code:
                changeUI(this, CaptureActivity.class);
                break;
            case R.id.ll_by_hand:
                break;
            case R.id.ll_by_net:
                break;
        }
    }
}
