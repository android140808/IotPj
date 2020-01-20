package cn.zhian.avater.iotproject.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.ImageView;

//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.ControlAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.bean.ControlBean;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.ui.activity.AddNewRoomUI;
import cn.zhian.avater.iotproject.utils.DataHelper;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class ControlFragment extends BaseFragment implements TittleManager.OnRightIvClickListener {

    @BindView(R.id.control_recyler_view)
    RecyclerView controlRecylerView;
    private ControlAdapter adapter;
    private List<ControlBean> list;

    @Override
    public BasePresenter createPresenter() {
        return null;
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
        list = DataHelper.getControlBeans(Applications.getPowerContext());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(RecyclerView.VERTICAL);
        adapter = new ControlAdapter(list, getActivity());
        controlRecylerView.setLayoutManager(manager);
        controlRecylerView.setAdapter(adapter);
    }

    @Override
    public void onRightIvClick() {
        changUI(AddNewRoomUI.class);
    }

    //    @OnClick(R.id.control_iv_add)
//    public void onViewClicked() {
//        changUI(AddNewRoomUI.class);
//    }
    @Override
    public void showLoading() {

    }
}
