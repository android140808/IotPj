package cn.zhian.avater.iotproject.ui.activity.control;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class TVControlUI extends BaseUI {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.edit)
    ImageView edit;
    @BindView(R.id.tv_sound_on_off)
    ImageView tvSoundOnOff;
    @BindView(R.id.tv_power_on_off)
    ImageView tvPowerOnOff;
    @BindView(R.id.tv_menu)
    ImageView tvMenu;
    @BindView(R.id.tv_sound_add)
    ImageView tvSoundAdd;
    @BindView(R.id.tv_sound_down)
    ImageView tvSoundDown;
    @BindView(R.id.tv_home)
    ImageView tvHome;
    @BindView(R.id.tv_channel_up)
    ImageView tvChannelUp;
    @BindView(R.id.tv_channel_down)
    ImageView tvChannelDown;
    @BindView(R.id.tv_back)
    ImageView tvBack;
    @BindView(R.id.tv_ok)
    Button tvOk;
    @BindView(R.id.tv_direct_up)
    ImageView tvDirectUp;
    @BindView(R.id.tv_direct_left)
    ImageView tvDirectLeft;
    @BindView(R.id.tv_direct_down)
    ImageView tvDirectDown;
    @BindView(R.id.tv_direct_right)
    ImageView tvDirectRight;
    @BindView(R.id.tv_find_channel)
    ImageView tvFindChannel;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.tv_control_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.back, R.id.edit, R.id.tv_sound_on_off, R.id.tv_power_on_off, R.id.tv_menu, R.id.tv_sound_add, R.id.tv_sound_down, R.id.tv_home, R.id.tv_channel_down, R.id.tv_back, R.id.tv_ok, R.id.tv_direct_up, R.id.tv_direct_left, R.id.tv_direct_down, R.id.tv_direct_right, R.id.tv_find_channel})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                closeUI();
                break;
            case R.id.edit:
                break;
            case R.id.tv_sound_on_off:
                break;
            case R.id.tv_power_on_off:
                break;
            case R.id.tv_menu:
                break;
            case R.id.tv_sound_add:
                break;
            case R.id.tv_sound_down:
                break;
            case R.id.tv_home:
                break;
            case R.id.tv_channel_down:
                break;
            case R.id.tv_back:
                break;
            case R.id.tv_ok:
                break;
            case R.id.tv_direct_up:
                break;
            case R.id.tv_direct_left:
                break;
            case R.id.tv_direct_down:
                break;
            case R.id.tv_direct_right:
                break;
            case R.id.tv_find_channel:
                break;
        }
    }
}
