package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseUI;

public class SenseUI extends BaseUI {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.sense_recyler_view)
    RecyclerView senseRecylerView;

    @Override
    public int getViewLayout() {
        return R.layout.sense_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.comm_tittle_iv_left)
    public void onViewClicked() {
        closeUI();
    }
}
