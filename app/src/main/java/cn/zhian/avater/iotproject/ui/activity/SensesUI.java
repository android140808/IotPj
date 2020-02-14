package cn.zhian.avater.iotproject.ui.activity;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;


public class SensesUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.sense_recyler_view)
    RecyclerView senseRecylerView;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.sense_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.setting_sense)
                .build();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void initData() {

    }


    @Override
    public void onLeftClick() {
        closeUI();
    }

    @OnClick(R.id.sense_add)
    public void onViewClicked() {
        changeUI(this, AddSenseUI.class);
    }
}
