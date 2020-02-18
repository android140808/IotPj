package cn.zhian.avater.iotproject.ui.fragment;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.CommMessageAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.bean.CommMessageBean;

public class MessagePustFragment extends BaseFragment {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout swipeRefresh;
    private List<CommMessageBean> mDataList;
    private CommMessageAdapter adapter;

    @Override
    public int getLayout() {
        return R.layout.message_security_ui;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void initData() {

    }

    @Override
    public void showLoading() {

    }
}
