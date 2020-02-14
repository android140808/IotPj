package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.CityBeans;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DataHelper;
import cn.zhian.avater.iotproject.utils.WheelViewDialog;

public class DownManagerSettingUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.custom_name)
    TextView customName;
    @BindView(R.id.custom_project_name)
    TextView customProjectName;
    @BindView(R.id.custom_setting_name)
    TextView customSettingName;
    List<CityBeans.CityBean> city;
    ArrayList<String> allProvinceList = new ArrayList<>();


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.down_manager_setting_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.manager_download)
                .build();
        allProvinceList.add("广东省");
    }

    @Override
    public void initData() {
        CityBeans cityBeans = DataHelper.getCities(this);
        if (cityBeans != null) {
            city = cityBeans.getCity();
            allProvinceList = new ArrayList<>();
            if (city != null && city.size() > 0) {
                for (CityBeans.CityBean cy : city) {
                    allProvinceList.add(cy.getName());
                }
            }
        }
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @OnClick({R.id.custom_province, R.id.custom_city, R.id.btn_down})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.custom_province:
                WheelViewDialog dialog = new WheelViewDialog.Builder()
                        .setContext(DownManagerSettingUI.this)
                        .setTittle("选择省份")
                        .setLeftData(allProvinceList)
                        .setLeftListener(value -> {
                            Log.e("TAG", "省份 = " + value);
                        })
                        .build();
                dialog.show();
                break;
            case R.id.custom_city:
                break;
            case R.id.btn_down:
                break;
        }
    }
}
