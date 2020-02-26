package cn.zhian.avater.iotproject.ui.activity.control;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class SenseModeUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightIvClickListener {

    @BindView(R.id.back)
    ImageView back;
    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.edit)
    ImageView edit;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.sense_mode_ui;
    }

    @Override
    public void findViewById() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void onLeftClick() {

    }

    @Override
    public void onRightIvClick() {

    }

    @OnClick({R.id.back, R.id.edit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back:
                closeUI();
                break;
            case R.id.edit:
                break;
        }
    }
}
