package cn.zhian.avater.iotproject.ui.activity.control;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;

public class AirConditionUI extends BaseUI {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.edit)
    ImageView edit;
    @BindView(R.id.air_menu)
    ImageView airMenu;
    @BindView(R.id.air_power_on_off)
    ImageView airPowerOnOff;
    @BindView(R.id.air_raise_wind)
    ImageView airRaiseWind;
    @BindView(R.id.air_mode_hot)
    ImageView airModeHot;
    @BindView(R.id.air_mode_cold)
    ImageView airModeCold;
    @BindView(R.id.air_sound_add)
    ImageView airSoundAdd;
    @BindView(R.id.air_sound_down)
    ImageView airSoundDown;
    @BindView(R.id.air_wind_direct)
    ImageView airWindDirect;
    @BindView(R.id.air_wind_speed)
    ImageView airWindSpeed;
    @BindView(R.id.air_sound_on_off)
    ImageView airSoundOnOff;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.air_condition_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back, R.id.edit, R.id.air_menu, R.id.air_power_on_off, R.id.air_raise_wind, R.id.air_mode_cold, R.id.air_sound_add, R.id.air_sound_down, R.id.air_wind_direct, R.id.air_wind_speed, R.id.air_sound_on_off})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                closeUI();
                break;
            case R.id.edit:
                break;
            case R.id.air_menu:
                break;
            case R.id.air_power_on_off:
                break;
            case R.id.air_raise_wind:
                break;
            case R.id.air_mode_cold:
                break;
            case R.id.air_sound_add:
                break;
            case R.id.air_sound_down:
                break;
            case R.id.air_wind_direct:
                break;
            case R.id.air_wind_speed:
                break;
            case R.id.air_sound_on_off:
                break;
        }
    }
}
