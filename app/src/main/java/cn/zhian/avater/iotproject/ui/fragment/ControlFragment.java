package cn.zhian.avater.iotproject.ui.fragment;

import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.ControlAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.bean.ControlBean;
import cn.zhian.avater.iotproject.utils.DataHelper;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class ControlFragment extends BaseFragment {

    @BindView(R.id.control_iv)
    ImageView controlIv;
    @BindView(R.id.control_tv_tittle)
    TextView controlTvTittle;
    @BindView(R.id.control_iv_add)
    ImageView controlIvAdd;
    @BindView(R.id.control_recyler_view)
    RecyclerView controlRecylerView;
    private ControlAdapter adapter;
    private List<ControlBean> list;

    @Override
    public int getLayout() {
        return R.layout.fragment_control;
    }

    @Override
    public void initData() {
        list = DataHelper.getControlBeans(Applications.getPowerContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        adapter = new ControlAdapter(list, getActivity());
        controlRecylerView.setLayoutManager(manager);
        controlRecylerView.setAdapter(adapter);
    }

    @OnClick(R.id.control_iv_add)
    public void onViewClicked() {
    }
}
