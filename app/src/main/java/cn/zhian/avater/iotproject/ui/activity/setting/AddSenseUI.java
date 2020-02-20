package cn.zhian.avater.iotproject.ui.activity.setting;


import android.os.Bundle;
import android.widget.EditText;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.SenseAdapter;
import cn.zhian.avater.iotproject.adapter.SenseExampleAdapter;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.AddHomeBean;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DataHelper;

public class AddSenseUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {

    @BindView(R.id.add_sense_name)
    EditText addSenseName;
    @BindView(R.id.recycler_view_icons)
    RecyclerView recyclerViewIcons;
    @BindView(R.id.recycler_view_examples)
    RecyclerView recyclerViewExamples;

    List<AddHomeBean> listIcons;
    SenseAdapter senseAdapter;
    List<AddHomeBean> listExamples;
    SenseExampleAdapter senseExampleAdapter;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.add_sense_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.sense_new)
                .setShowRightTv(true)
                .setRightRes(R.string.save)
                .setRightTvColor(R.color.home_icon_bg)
                .setRightTvListener(this)
                .build();
    }

    @Override
    public void initData() {
        listIcons = DataHelper.getSenseIcons();
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        recyclerViewIcons.setLayoutManager(manager);
        senseAdapter = new SenseAdapter(this, listIcons);
        recyclerViewIcons.setAdapter(senseAdapter);
        senseAdapter.setItemClickListener(onClick);

        listExamples = DataHelper.getSenseExampleIcons();
        GridLayoutManager manager1 = new GridLayoutManager(this, 4);
        recyclerViewExamples.setLayoutManager(manager1);
        senseExampleAdapter = new SenseExampleAdapter(this, listExamples);
        senseExampleAdapter.setItemClickListener(click);
        recyclerViewExamples.setAdapter(senseExampleAdapter);
    }

    SenseExampleAdapter.OnClick click = (state, position) -> {
        Bundle bundle = new Bundle();
        bundle.putInt("type", position);
        changeUI(AddSenseUI.this, Sense4TypeUI.class, bundle);
    };

    SenseAdapter.OnClick onClick = (state, position) -> {
        for (AddHomeBean ab : listIcons) {
            ab.setSelect(false);
        }
        listIcons.get(position).setSelect(state);
        senseAdapter.notifyDataSetChanged();
    };

    @Override
    public void showLoading() {

    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onRightTvClick() {
        changeUI(this, CustomSenseUI.class);
    }

}
