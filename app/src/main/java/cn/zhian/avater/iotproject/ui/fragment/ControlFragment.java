package cn.zhian.avater.iotproject.ui.fragment;

import android.util.Log;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import cn.zhian.avater.databasemodule.tables.RoomDB;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.ControlAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.ui.activity.control.AddNewRoomUI;
import cn.zhian.avater.iotproject.ui.presenter.ControlPresenter;
import cn.zhian.avater.iotproject.ui.view.ControlView;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class ControlFragment extends BaseFragment<ControlView, ControlPresenter> implements TittleManager.OnRightIvClickListener, ControlView {

    @BindView(R.id.control_recyler_view)
    RecyclerView controlRecylerView;

    private ControlAdapter adapter;
    private List<RoomDB> roomDBList = new ArrayList<>();

    @Override
    public ControlPresenter createPresenter() {
        return new ControlPresenter();
    }

    @Override
    public int getLayout() {
        return R.layout.fragment_control;
    }

    @Override
    public void initData() {
        tittleManager = new TittleManager.Builder()
                .setView(view.findViewById(R.id.tittle_content))
                .setShowMiddle(true)
                .setMiddleRes(R.string.main_tv_control)
                .setShowRightIv(true)
                .setRightIvListener(this)
                .setRightIcon(R.mipmap.add)
                .build();
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        adapter = new ControlAdapter(roomDBList, getActivity());
        adapter.setLongClick(itemOnClickListener);
        adapter.setOnClick(onClick);
        controlRecylerView.setLayoutManager(manager);
        controlRecylerView.setAdapter(adapter);
        if (accountDB != null) {
            mPresenter.getAllRoom(getActivity(), mCurrentPhoneNumber, accountDB.getAccountId());
        }
    }

    private ControlAdapter.OnClick onClick = ((data, position) -> {
        Log.e("TAG", "点击");
    });

    private ControlAdapter.OnLongClick itemOnClickListener = (data, position) -> {
        Log.e("TAG", "长按");
    };

    @Override
    public void onRightIvClick() {
        changUI(AddNewRoomUI.class);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void getRoomDBList(List<RoomDB> list) {
        Log.e("TAG", "主页收到数据 list = " + list.size());
        adapter.addRoomAll(list);
    }
}
