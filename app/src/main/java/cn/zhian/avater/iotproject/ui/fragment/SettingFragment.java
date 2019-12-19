package cn.zhian.avater.iotproject.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseFragment;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class SettingFragment extends BaseFragment {

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
    public int getLayout() {
        return R.layout.fragment_setting;
    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.setting_rl_person, R.id.setting_rl_sense, R.id.setting_rl_manager, R.id.setting_rl_password, R.id.setting_rl_connect, R.id.setting_rl_refresh, R.id.setting_rl_recover})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.setting_rl_person:
                break;
            case R.id.setting_rl_sense:
                break;
            case R.id.setting_rl_manager:
                break;
            case R.id.setting_rl_password:
                break;
            case R.id.setting_rl_connect:
                break;
            case R.id.setting_rl_refresh:
                break;
            case R.id.setting_rl_recover:
                break;
        }
    }
}
