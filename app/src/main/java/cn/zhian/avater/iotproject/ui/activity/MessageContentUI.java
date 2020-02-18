package cn.zhian.avater.iotproject.ui.activity;

import android.graphics.Color;
import android.os.Bundle;

import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.MainUIAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.ui.fragment.MessageEnvirFragment;
import cn.zhian.avater.iotproject.ui.fragment.MessagePustFragment;
import cn.zhian.avater.iotproject.ui.fragment.MessageSecurityFragment;

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

    private MainUIAdapter adapter;
    private List<BaseFragment> list;
    private int mCurrentTag = 0;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void showLoading() {

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
        list = new ArrayList<>();
        list.add(new MessageSecurityFragment());
        list.add(new MessageEnvirFragment());
        list.add(new MessagePustFragment());
        adapter = new MainUIAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                selectType(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPager.setCurrentItem(mCurrentTag);
    }


    @OnClick({R.id.comm_tittle_iv_left, R.id.ll_security, R.id.ll_environment, R.id.ll_pull})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.ll_security:
                selectType(0);
                viewPager.setCurrentItem(0);
                break;
            case R.id.ll_environment:
                selectType(1);
                viewPager.setCurrentItem(1);
                break;
            case R.id.ll_pull:
                selectType(2);
                viewPager.setCurrentItem(2);
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
