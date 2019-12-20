package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseUI;

public class ConnectTypeUI extends BaseUI {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.connect_type_iv_inner_select)
    ImageView connectTypeIvInnerSelect;
    @BindView(R.id.connect_type_rl_inner)
    RelativeLayout connectTypeRlInner;
    @BindView(R.id.connect_type_iv_out_select)
    ImageView connectTypeIvOutSelect;
    @BindView(R.id.connect_type_rl_out)
    RelativeLayout connectTypeRlOut;
    @BindView(R.id.connect_type_iv_auto_select)
    ImageView connectTypeIvAutoSelect;
    @BindView(R.id.connect_type_rl_auto)
    RelativeLayout connectTypeRlAuto;

    @Override
    public int getViewLayout() {
        return R.layout.connect_type_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @OnClick({R.id.comm_tittle_iv_left, R.id.connect_type_iv_inner_select, R.id.connect_type_rl_inner, R.id.connect_type_iv_out_select, R.id.connect_type_rl_out, R.id.connect_type_iv_auto_select, R.id.connect_type_rl_auto})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comm_tittle_iv_left:
                closeUI();
                break;
            case R.id.connect_type_iv_inner_select:
                break;
            case R.id.connect_type_rl_inner:
                break;
            case R.id.connect_type_iv_out_select:
                break;
            case R.id.connect_type_rl_out:
                break;
            case R.id.connect_type_iv_auto_select:
                break;
            case R.id.connect_type_rl_auto:
                break;
        }
    }
}
