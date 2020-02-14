package cn.zhian.avater.iotproject.ui.activity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.appcompat.app.AlertDialog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class ManagerUI extends BaseUI implements TittleManager.OnLeftClickListener {

    @BindView(R.id.manager_rl_up_load)
    RelativeLayout managerRlUpLoad;
    @BindView(R.id.manager_down_load)
    RelativeLayout managerDownLoad;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.manager_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.setting_manager)
                .build();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.manager_rl_up_load, R.id.manager_down_load})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.manager_rl_up_load:
                AlertDialog dialog = new AlertDialog.Builder(ManagerUI.this)
                        .setMessage("是否确认上传配置")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确认", (dialog1, which) -> {
                        })
                        .create();
                dialog.setCanceledOnTouchOutside(false);
                dialog.setCancelable(false);
                dialog.show();
                break;
            case R.id.manager_down_load:
                AlertDialog dialogDown = new AlertDialog.Builder(ManagerUI.this)
                        .setMessage("是否下载2019-11-12配置")
                        .setNegativeButton("取消", null)
                        .setPositiveButton("确认", (dialog1, which) -> {
                            changeUI(ManagerUI.this, DownManagerSettingUI.class);
                        })
                        .create();
                dialogDown.setCanceledOnTouchOutside(false);
                dialogDown.setCancelable(false);
                dialogDown.show();
                break;
        }
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
