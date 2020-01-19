package cn.zhian.avater.iotproject.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.ui.activity.ConnectTypeUI;
import cn.zhian.avater.iotproject.ui.activity.LoginUI;
import cn.zhian.avater.iotproject.ui.activity.ManagerUI;
import cn.zhian.avater.iotproject.ui.activity.PasswordUI;
import cn.zhian.avater.iotproject.ui.activity.PersonUI;
import cn.zhian.avater.iotproject.ui.activity.SenseUI;
import cn.zhian.avater.iotproject.ui.presenter.SettingPresenter;
import cn.zhian.avater.iotproject.ui.view.SettintView;
import cn.zhian.avater.iotproject.widget.ResetView;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class SettingFragment extends BaseFragment<SettintView, SettingPresenter<SettintView>> implements SettintView, ResetView.doSomeTing {

    @BindView(R.id.setting_iv_personal)
    ImageView settingIvPersonal;
    @BindView(R.id.setting_rl_person)
    RelativeLayout settingRlPerson;
    @BindView(R.id.setting_iv_sense)
    ImageView settingIvSense;
    @BindView(R.id.setting_rl_sense)
    RelativeLayout settingRlSense;
    @BindView(R.id.setting_iv_manager)
    ImageView settingIvManager;
    @BindView(R.id.setting_rl_manager)
    RelativeLayout settingRlManager;
    @BindView(R.id.setting_iv_pass)
    ImageView settingIvPass;
    @BindView(R.id.setting_rl_password)
    RelativeLayout settingRlPassword;
    @BindView(R.id.setting_iv_connect)
    ImageView settingIvConnect;
    @BindView(R.id.setting_rl_connect)
    RelativeLayout settingRlConnect;
    @BindView(R.id.setting_iv_server)
    ImageView settingIvServer;
    @BindView(R.id.setting_rl_refresh)
    RelativeLayout settingRlRefresh;
    @BindView(R.id.setting_iv_recover)
    ImageView settingIvRecover;
    @BindView(R.id.setting_rl_recover)
    RelativeLayout settingRlRecover;

    @Override
    public SettingPresenter createPresenter() {
        return new SettingPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initData() {
        tittleManager = new TittleManager.Builder()
                .setView(view.findViewById(R.id.tittle_content))
                .setShowMiddle(true)
                .setMiddleRes(R.string.main_tv_setting)
                .build();
    }

    @OnClick({R.id.setting_tv_logout, R.id.setting_rl_person, R.id.setting_rl_sense, R.id.setting_rl_manager, R.id.setting_rl_password, R.id.setting_rl_connect, R.id.setting_rl_refresh, R.id.setting_rl_recover})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_rl_person:
                changUI(PersonUI.class);
                break;
            case R.id.setting_rl_sense:
                changUI(SenseUI.class);
                break;
            case R.id.setting_rl_manager:
                changUI(ManagerUI.class);
                break;
            case R.id.setting_rl_password:
                changUI(PasswordUI.class);
                break;
            case R.id.setting_rl_connect:
                changUI(ConnectTypeUI.class);
                break;
            case R.id.setting_rl_refresh:
                showToast("正在刷新服务器");
                break;
            case R.id.setting_rl_recover:
                ResetView resetView = new ResetView(getActivity());
                resetView.setListener(SettingFragment.this);
                resetView.show();
                break;
            case R.id.setting_tv_logout:
                changUI(LoginUI.class);
                getActivity().finish();
//                mPresenter.logout();
                break;
        }
    }

    @Override
    public void doIt() {
        showToast("开始恢复出厂设置了哟！！");
    }

    @Override
    public void logout() {

    }
}
