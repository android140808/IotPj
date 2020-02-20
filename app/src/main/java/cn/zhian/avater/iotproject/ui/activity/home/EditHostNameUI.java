package cn.zhian.avater.iotproject.ui.activity.home;

import android.widget.EditText;

import butterknife.BindView;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class EditHostNameUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {

    @BindView(R.id.edit_host_name)
    EditText editHostName;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.edit_host_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.edit_host)
                .setShowRightTv(true)
                .setRightTvColor(R.color.home_icon_bg)
                .setRightRes(R.string.save)
                .setRightTvListener(this)
                .build();
    }

    @Override
    public void initData() {

    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onRightTvClick() {
        showToast("保存");
    }
}
