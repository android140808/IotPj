package cn.zhian.avater.iotproject.ui.fragment;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

//import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class RunningFragment extends BaseFragment {

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

    }
}
