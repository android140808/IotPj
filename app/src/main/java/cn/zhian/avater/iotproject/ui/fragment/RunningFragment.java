package cn.zhian.avater.iotproject.ui.fragment;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.ui.TittleManager;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class RunningFragment extends BaseFragment implements TittleManager.OnRightIvClickListener {

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_running;
    }

    @Override
    public void initData() {
        tittleManager = new TittleManager.Builder()
                .setView(view.findViewById(R.id.tittle_content))
                .setShowMiddle(true)
                .setMiddleRes(R.string.main_tv_running_devices)
                .setShowRightIv(true)
                .setRightIvListener(this)
                .setRightIcon(R.mipmap.stop)
                .build();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onRightIvClick() {
        showToast("关闭所有设备");
    }
}
