package cn.zhian.avater.iotproject.ui.activity;

import androidx.viewpager.widget.ViewPager;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.MainUIAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.fragment.ControlFragment;
import cn.zhian.avater.iotproject.ui.fragment.HomeFragment;
import cn.zhian.avater.iotproject.ui.fragment.RunningFragment;
import cn.zhian.avater.iotproject.ui.fragment.SettingFragment;
import cn.zhian.avater.iotproject.utils.GeneralMethods;

public class MainUI extends BaseUI {


    @BindView(R.id.main_view_pager)
    ViewPager mainViewPager;
    @BindView(R.id.main_bottom_iv_home)
    ImageView mainBottomIvHome;
    @BindView(R.id.main_bottom_tv_home)
    TextView mainBottomTvHome;
    @BindView(R.id.main_bottom_ll_home)
    LinearLayout mainBottomLlHome;
    @BindView(R.id.main_bottom_iv_control)
    ImageView mainBottomIvControl;
    @BindView(R.id.main_bottom_tv_control)
    TextView mainBottomTvControl;
    @BindView(R.id.main_bottom_ll_control)
    LinearLayout mainBottomLlControl;
    @BindView(R.id.main_bottom_iv_running)
    ImageView mainBottomIvRunning;
    @BindView(R.id.main_bottom_tv_running)
    TextView mainBottomTvRunning;
    @BindView(R.id.main_bottom_ll_running)
    LinearLayout mainBottomLlRunning;
    @BindView(R.id.main_bottom_iv_setting)
    ImageView mainBottomIvSetting;
    @BindView(R.id.main_bottom_tv_setting)
    TextView mainBottomTvSetting;
    @BindView(R.id.main_bottom_ll_setting)
    LinearLayout mainBottomLlSetting;
    private HomeFragment homeFragment;
    private ControlFragment controlFragment;
    private RunningFragment runningFragment;
    private SettingFragment settingFragment;
    private MainUIAdapter adapter;
    private List<BaseFragment> fragmentList = new ArrayList<>();
    private long mExistTimes;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {
        homeFragment = new HomeFragment();
        fragmentList.add(homeFragment);
        controlFragment = new ControlFragment();
        fragmentList.add(controlFragment);
        runningFragment = new RunningFragment();
        fragmentList.add(runningFragment);
        settingFragment = new SettingFragment();
        fragmentList.add(settingFragment);
        mainViewPager.setOffscreenPageLimit(fragmentList.size());
        adapter = new MainUIAdapter(getSupportFragmentManager(), fragmentList);
        mainViewPager.setAdapter(adapter);
        mainViewPager.setCurrentItem(0);
        mainViewPager.addOnPageChangeListener(listener);
    }

    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            setBottomViewState(position);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };


    @OnClick({R.id.main_bottom_ll_home, R.id.main_bottom_ll_control, R.id.main_bottom_ll_running, R.id.main_bottom_ll_setting})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_bottom_ll_home:
                mainViewPager.setCurrentItem(0);
                setBottomViewState(0);
                break;
            case R.id.main_bottom_ll_control:
                mainViewPager.setCurrentItem(1);
                setBottomViewState(1);
                break;
            case R.id.main_bottom_ll_running:
                mainViewPager.setCurrentItem(2);
                setBottomViewState(2);
                break;
            case R.id.main_bottom_ll_setting:
                mainViewPager.setCurrentItem(3);
                setBottomViewState(3);
                break;
        }
    }

    private void setBottomViewState(int position) {
        mainBottomTvHome.setTextColor(getResources().getColor(R.color.main_tv_un_select));
        mainBottomIvHome.setBackgroundResource(R.mipmap.main_bottom_home_un_select);
        mainBottomTvControl.setTextColor(getResources().getColor(R.color.main_tv_un_select));
        mainBottomIvControl.setBackgroundResource(R.mipmap.main_bottom_contro_un_select);
        mainBottomTvRunning.setTextColor(getResources().getColor(R.color.main_tv_un_select));
        mainBottomIvRunning.setBackgroundResource(R.mipmap.main_bottom_running_un_select);
        mainBottomTvSetting.setTextColor(getResources().getColor(R.color.main_tv_un_select));
        mainBottomIvSetting.setBackgroundResource(R.mipmap.main_bottom_setting_un_select);
        switch (position) {
            case 0:
                mainBottomTvHome.setTextColor(getResources().getColor(R.color.main_tv_select));
                mainBottomIvHome.setBackgroundResource(R.mipmap.main_bottom_home_select);
                break;
            case 1:
                mainBottomTvControl.setTextColor(getResources().getColor(R.color.main_tv_select));
                mainBottomIvControl.setBackgroundResource(R.mipmap.main_bottom_control_select);
                break;
            case 2:
                mainBottomTvRunning.setTextColor(getResources().getColor(R.color.main_tv_select));
                mainBottomIvRunning.setBackgroundResource(R.mipmap.main_bottom_running_select);
                break;
            case 3:
                mainBottomTvSetting.setTextColor(getResources().getColor(R.color.main_tv_select));
                mainBottomIvSetting.setBackgroundResource(R.mipmap.main_bottom_setting_select);
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (!GeneralMethods.existApps(mExistTimes)) {
                showToast(R.string.exist);
                mExistTimes = System.currentTimeMillis();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
