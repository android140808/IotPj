package cn.zhian.avater.iotproject.ui.activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;

//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.AddRoomAdapter;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.AddHomeBean;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DataHelper;

public class AddNewRoomUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private AddRoomAdapter addRoomAdapter;
    private List<AddHomeBean> mData;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.add_new_room_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.add_new_room)
                .build();
    }

    @Override
    public void initData() {
        mData = DataHelper.getHomeBean(this);
        addRoomAdapter = new AddRoomAdapter(this, mData);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(addRoomAdapter);
        addRoomAdapter.setItemClickListener(onClick);
    }

    private AddRoomAdapter.OnClick onClick = (type, position) -> {
        changeUI(AddNewRoomUI.this, CustomerRoomUI.class);
    };


    @Override
    public void onLeftClick() {
        closeUI();
    }
}
