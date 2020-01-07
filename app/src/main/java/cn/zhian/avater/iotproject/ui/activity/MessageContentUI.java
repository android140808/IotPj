package cn.zhian.avater.iotproject.ui.activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class MessageContentUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.tv_security)
    TextView tvSecurity;
    @BindView(R.id.view_security)
    View viewSecurity;
    @BindView(R.id.ll_security)
    LinearLayout llSecurity;
    @BindView(R.id.tv_environment)
    TextView tvEnvironment;
    @BindView(R.id.view_environment)
    View viewEnvironment;
    @BindView(R.id.ll_environment)
    LinearLayout llEnvironment;
    @BindView(R.id.tv_pull)
    TextView tvPull;
    @BindView(R.id.view_pull)
    View viewPull;
    @BindView(R.id.ll_pull)
    LinearLayout llPull;
    @BindView(R.id.view_pager)
    ViewPager viewPager;

    private int mCurrentTag = 0;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.message_content_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.message_content_tittle)
                .build();
    }

    @Override
    public void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            mCurrentTag = extras.getInt("TAG", 0);
        }
        selectType(mCurrentTag);
    }


    @OnClick({R.id.comm_tittle_iv_left, R.id.ll_security, R.id.ll_environment, R.id.ll_pull})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_security:
                selectType(0);
                break;
            case R.id.ll_environment:
                selectType(1);
                break;
            case R.id.ll_pull:
                selectType(2);
                break;
        }
    }

    private void selectType(int position) {
        reSet();
        switch (position) {
            case 0:
                tvSecurity.setTextColor(getResources().getColor(R.color.home_icon_bg));
                viewSecurity.setBackgroundColor(getResources().getColor(R.color.home_icon_bg));
                break;
            case 1:
                tvEnvironment.setTextColor(getResources().getColor(R.color.home_icon_bg));
                viewEnvironment.setBackgroundColor(getResources().getColor(R.color.home_icon_bg));
                break;
            case 2:
                tvPull.setTextColor(getResources().getColor(R.color.home_icon_bg));
                viewPull.setBackgroundColor(getResources().getColor(R.color.home_icon_bg));
                break;
        }
    }

    private void reSet() {
        tvSecurity.setTextColor(Color.BLACK);
        viewSecurity.setBackgroundColor(getResources().getColor(R.color.color_while));
        tvEnvironment.setTextColor(Color.BLACK);
        viewEnvironment.setBackgroundColor(getResources().getColor(R.color.color_while));
        tvPull.setTextColor(Color.BLACK);
        viewPull.setBackgroundColor(getResources().getColor(R.color.color_while));
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
