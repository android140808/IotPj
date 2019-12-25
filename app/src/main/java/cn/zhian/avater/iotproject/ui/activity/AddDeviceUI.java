package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;

public class AddDeviceUI extends BaseUI {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.add_device_ed_name)
    EditText addDeviceEdName;
    @BindView(R.id.add_device_recycler_view_left)
    RecyclerView addDeviceRecyclerViewLeft;
    @BindView(R.id.add_device_recycler_view_right)
    RecyclerView addDeviceRecyclerViewRight;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.add_device_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }


    @OnClick(R.id.comm_tittle_iv_left)
    public void onViewClicked() {
    }
}
