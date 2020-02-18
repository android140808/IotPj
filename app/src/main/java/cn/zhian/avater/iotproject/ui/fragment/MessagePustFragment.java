package cn.zhian.avater.iotproject.ui.fragment;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.CommMessageAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.bean.CommMessageBean;
import cn.zhian.avater.iotproject.ui.activity.MessageDetailUI;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.responseBean.CommMessageResponse;

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
        mDataList = new ArrayList<>();
        adapter = new CommMessageAdapter(getActivity(), mDataList);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        ServerRequest.INSTANCE.getMessagePush(0, 10, new NetResultCallBack<CommMessageResponse>() {
            @Override
            public void onSuccess(int responseCode, CommMessageResponse cmr) {
                if (cmr != null && cmr.getData() != null && cmr.getData().size() > 0) {
                    for (CommMessageResponse.Data data : cmr.getData()) {
                        boolean isRead = false;
                        if (data.getIsRead().equals("1")) {// 1：未读 0：已读
                            isRead = false;
                        } else {//已读
                            isRead = true;
                        }
                        CommMessageBean cmd = new CommMessageBean(1, isRead, data.getTitle(), data.getContent(), data.getCreateDate());
                        mDataList.add(cmd);
                    }
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFail(int responseCode) {

            }
        });
        adapter.setItemListener((type, position) -> {
            CommMessageBean bean = mDataList.get(position);
            Bundle bundle = new Bundle();
            bundle.putString("tittle", bean.tittle);
            bundle.putString("date", bean.date);
            bundle.putString("content", bean.detail);
            changUI(MessageDetailUI.class, bundle);
        });
    }

    @Override
    public void showLoading() {

    }
}
