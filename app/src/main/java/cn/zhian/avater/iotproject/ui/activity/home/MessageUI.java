package cn.zhian.avater.iotproject.ui.activity.home;


import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import java.util.List;

import butterknife.BindView;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.CommItemListener;
import cn.zhian.avater.iotproject.adapter.MessageUIAdapter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.MessageType;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.ui.activity.home.MessageContentUI;
import cn.zhian.avater.iotproject.ui.presenter.MessageUIPresenter;
import cn.zhian.avater.iotproject.ui.view.MessageUiView;
import cn.zhian.avater.iotproject.utils.DataHelper;

public class MessageUI extends BaseUI<MessageUiView, MessageUIPresenter<MessageUiView>> implements MessageUiView, TittleManager.OnLeftClickListener, CommItemListener {

    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.swipe_refresh)
    SwipeRefreshLayout refreshLayout;
    private MessageUIAdapter adapter;
    private List<MessageType> mDataList;

    @Override
    public MessageUIPresenter createPresenter() {
        return new MessageUIPresenter();
    }

    @Override
    public int getViewLayout() {
        return R.layout.message_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.message_total)
                .build();
    }

    @Override
    public void initData() {
        showLoading();
        mDataList = DataHelper.getMessageTypes();
        refreshLayout.setOnRefreshListener(() -> {
            refreshLayout.setRefreshing(true);
            mPresenter.getAllMessage(1, 10);
        });
        adapter = new MessageUIAdapter(this, mDataList);
        LinearLayoutManager manger = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manger);
        recyclerView.setAdapter(adapter);
        adapter.setItemListener(this);
        mPresenter.getAllMessage(1, 10);
        refreshLayout.setRefreshing(true);
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onItemClick(int type, int position) {
        Bundle bundle = new Bundle();
        switch (type) {
            case 0:
                bundle.putInt("TAG", 0);
                break;
            case 1:
                bundle.putInt("TAG", 1);
                break;
            case 2:
                bundle.putInt("TAG", 2);
                break;
        }
        changeUI(this, MessageContentUI.class, bundle);
    }

    @Override
    public void closeDialog() {
        refreshLayout.setRefreshing(false);
        closeLoading();
    }

    @Override
    public void updateMessageCount(int type, int count, String firstContent) {
        adapter.updateList(type, count, firstContent);
    }
}
