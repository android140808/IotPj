package cn.zhian.avater.iotproject.ui.activity.control;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.LightAdapter;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.LightBean;
import cn.zhian.avater.iotproject.utils.DataHelper;
import cn.zhian.avater.iotproject.utils.WheelViewDialog;

public class LightUI extends BaseUI implements LightAdapter.CallBack {


    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.edit)
    ImageView edit;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.tv_switch_on)
    TextView tvSwitchOn;
    @BindView(R.id.tv_switch_off)
    TextView tvSwitchOff;
    @BindView(R.id.ll_switch_all)
    LinearLayout llSwitchAll;

    private List<LightBean> mBean = new ArrayList<>();
    private LightAdapter adapter;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.light_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {
        mBean = DataHelper.getLightBeans();
        adapter = new LightAdapter(this, mBean);
        adapter.setCallBackListener(this);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.HORIZONTAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
    }

    @OnClick({R.id.back, R.id.ll_switch_all, R.id.edit, R.id.tv_switch_on, R.id.tv_switch_off})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                closeUI();
                break;
            case R.id.edit:
                break;
            case R.id.tv_switch_on:
                setBg(1);
                break;
            case R.id.tv_switch_off:
                setBg(0);
                break;
        }
    }

    private void setBg(int type) {
        switch (type) {
            case 0:
                tvSwitchOff.setBackgroundResource(R.drawable.light_item_1);
                tvSwitchOn.setBackgroundResource(R.drawable.light_item_0);
                //TODO
                break;
            case 1:
                tvSwitchOn.setBackgroundResource(R.drawable.light_item_1);
                tvSwitchOff.setBackgroundResource(R.drawable.light_item_0);
                //TODO
                break;
        }
    }

    @Override
    public void callBack(boolean switchState, int hour, int minute, int second, int position) {
        Log.d("TAG", "switchState = " + switchState + ",hour = " + hour + ",minute = " + minute + ", second= " + second + ",position = " + position);
        showDialog();
    }

    private void showDialog() {
        ArrayList<String> leftData = DataHelper.getHours12();
        ArrayList<String> middleData = DataHelper.getMinutes();
        ArrayList<String> rightData = DataHelper.getSeconds();
        WheelViewDialog wheelView = new WheelViewDialog.Builder()
                .setContext(this)
                .setTittle("设置定时关闭")
                .setLeftData(leftData)
                .setLeftIndex(0)
                .setLeftListener(value -> {
                    Log.e("自定义时间", "小时 = " + value);
                })
                .setMiddleData(middleData)
                .setMiddleIndex(0)
                .setMiddleListener(value -> {
                    Log.e("自定义时间", "分钟 = " + value);
                })
                .setRightData(rightData)
                .setRightIndex(0)
                .setRightListener(value -> {
                    Log.e("自定义时间", "秒 = " + value);
                })
                .build();
        wheelView.show();
    }

    @Override
    public void changeBg(int position) {
        Log.d("TAG", "position = " + position);
        for (LightBean lb : mBean) {
            lb.setSelectState(false);
        }
        mBean.get(position).setSelectState(true);
        adapter.notifyDataSetChanged();
    }
}
