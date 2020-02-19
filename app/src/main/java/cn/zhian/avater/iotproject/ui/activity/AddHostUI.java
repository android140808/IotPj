package cn.zhian.avater.iotproject.ui.activity;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DialogUtils;
import cn.zhian.avater.iotproject.zxing.android.CaptureActivity;

public class AddHostUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.ll_qr_code)
    LinearLayout llQrCode;
    @BindView(R.id.ll_by_hand)
    LinearLayout llByHand;
    @BindView(R.id.ll_by_net)
    LinearLayout llByNet;

    AlertDialog inputdialog;
    AlertDialog connectDialog;
    AlertDialog passwordDialog;

    @SuppressLint("HandlerLeak")
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    connectDialog.dismiss();
                    passwordDialog = DialogUtils.getDialog(AddHostUI.this, R.string.reset_password, new DialogUtils.CallBackString() {
                        @Override
                        public void cancel() {
                            passwordDialog.dismiss();
                        }

                        @Override
                        public void backString(String value) {
                            if (TextUtils.isEmpty(value)) {
                                showToast("请输入密码");
                            } else {
                                //todo 检验密码
                                showToast("密码正确");
                                passwordDialog.dismiss();
                                changeUI(AddHostUI.this, EditHostNameUI.class);
                            }
                        }
                    });
                    passwordDialog.show();
                    break;
            }
        }
    };


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
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.add_host)
                .build();
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.ll_qr_code, R.id.ll_by_hand, R.id.ll_by_net})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_qr_code:
                changeUI(this, CaptureActivity.class);
                break;
            case R.id.ll_by_hand:
                inputdialog = DialogUtils.getDialog(this, R.string.input_device_number, new DialogUtils.CallBackString() {
                    @Override
                    public void cancel() {
                        inputdialog.dismiss();
                    }

                    @Override
                    public void backString(String value) {
                        if (!TextUtils.isEmpty(value)) {
                            inputdialog.dismiss();
                            connectDialog = DialogUtils.getConnectDialog(AddHostUI.this);
                            connectDialog.show();
                            mHandler.sendEmptyMessageDelayed(0, 3000);
                        } else {
                            showToast("请输入设备编号");
                        }
                    }
                });
                inputdialog.show();
                break;
            case R.id.ll_by_net:
                break;
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
