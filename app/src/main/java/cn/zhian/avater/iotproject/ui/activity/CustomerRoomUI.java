package cn.zhian.avater.iotproject.ui.activity;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.CustomerAdapter;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.AddHomeBean;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DataHelper;

public class CustomerRoomUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.comm_tittle_tv_right)
    TextView commTittleTvRight;
    @BindView(R.id.customer_et_input)
    EditText customerEtInput;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private CustomerAdapter adapter;
    private List<AddHomeBean> mData;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.customer_room_ui;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.room_often)
                .setShowRightTv(true)
                .setRightRes(R.string.save)
                .setRightTvListener(this)
                .build();
    }

    @Override
    public void initData() {
        mData = DataHelper.getIcons();
        GridLayoutManager manager = new GridLayoutManager(this, 4);
        adapter = new CustomerAdapter(this, mData);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);
        adapter.setItemClickListener(onClick);
    }

    private CustomerAdapter.OnClick onClick = (state, position) -> {
        for (AddHomeBean ab : mData) {
            ab.setSelect(false);
        }
        mData.get(position).setSelect(state);
        adapter.notifyDataSetChanged();
    };

    @OnClick({R.id.comm_tittle_iv_left, R.id.comm_tittle_tv_right})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.comm_tittle_iv_left:
                closeUI();
                break;
            case R.id.comm_tittle_tv_right:
                break;
        }
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onRightTvClick() {
        showToast("保存成功");
    }
}
