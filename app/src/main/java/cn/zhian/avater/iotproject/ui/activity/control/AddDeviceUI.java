package cn.zhian.avater.iotproject.ui.activity.control;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.LeftAdapter;
import cn.zhian.avater.iotproject.adapter.RightAdapter;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.LeftBean;
import cn.zhian.avater.iotproject.bean.RightBean;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DataHelper;

public class AddDeviceUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightTvClickListener {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.add_device_ed_name)
    EditText addDeviceEdName;
    @BindView(R.id.add_device_recycler_view_left)
    RecyclerView addDeviceRecyclerViewLeft;
    @BindView(R.id.add_device_recycler_view_right1)
    RecyclerView addDeviceRecyclerViewRight1;
    @BindView(R.id.add_device_recycler_view_right2)
    RecyclerView addDeviceRecyclerViewRight2;
    @BindView(R.id.tittle1)
    TextView tittle1;
    @BindView(R.id.tittle2)
    TextView tittle2;
    @BindView(R.id.ll_ks)
    LinearLayout ll_ks;
    private LeftAdapter leftAdapter;
    private List<LeftBean> mLeftData;
    private RightAdapter rightAdapter;
    private RightAdapter rightAdapter2;
    private List<RightBean> mRightData;
    private List<RightBean> mRightData2;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.add_device_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.add_new_device)
                .setShowRightTv(true)
                .setRightRes(R.string.add)
                .setRightTvListener(this)
                .build();
    }

    @Override
    public void initData() {
        hideSoftInput();
        mLeftData = DataHelper.getLeftData(this);
        mRightData = DataHelper.getRightData(this, 0);
        rightAdapter = new RightAdapter(this, mRightData);
        leftAdapter = new LeftAdapter(this, mLeftData);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(RecyclerView.VERTICAL);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 3);
        addDeviceRecyclerViewRight1.setLayoutManager(gridLayoutManager);
        addDeviceRecyclerViewLeft.setLayoutManager(manager);
        addDeviceRecyclerViewLeft.setAdapter(leftAdapter);
        leftAdapter.setItemClickListener(click);
        addDeviceRecyclerViewRight1.setAdapter(rightAdapter);
        rightAdapter.setItemClickListener(rightClick1);
    }

    private void setRightTwoRecyclerView(boolean isShowKS, int type) {
        if (isShowKS) {
            tittle1.setVisibility(View.VISIBLE);
            tittle1.setText(R.string.switch_kx);
            ll_ks.setVisibility(View.VISIBLE);
            tittle2.setText(R.string.switch_ks);
            mRightData2 = DataHelper.getRightData(this, 6);
            if (rightAdapter2 == null) {
                rightAdapter2 = new RightAdapter(this, mRightData2);
                rightAdapter2.setItemClickListener(rightClick2);
                GridLayoutManager manager = new GridLayoutManager(this, 3);
                addDeviceRecyclerViewRight2.setLayoutManager(manager);
                addDeviceRecyclerViewRight2.setAdapter(rightAdapter2);
            }
            rightAdapter2.update(mRightData2, 0);
        } else {
            ll_ks.setVisibility(View.GONE);
            tittle1.setVisibility(View.GONE);
        }
        mRightData.clear();
        mRightData.addAll(DataHelper.getRightData(this, type));
        rightAdapter.update(mRightData, type);
    }

    private RightAdapter.OnClick rightClick1 = (type, position) -> {
        showToast(type + " , " + position);
    };
    private RightAdapter.OnClick rightClick2 = (type, position) -> {
        showToast(type + " , " + position);
    };

    private LeftAdapter.OnClick click = position -> {
        for (LeftBean lb : mLeftData) {
            lb.setSelect(false);
        }
        mLeftData.get(position).setSelect(true);
        leftAdapter.notifyDataSetChanged();
        if (position == 1) {
            setRightTwoRecyclerView(true, position);
        } else
            setRightTwoRecyclerView(false, position);
    };

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void onRightTvClick() {

    }
}
