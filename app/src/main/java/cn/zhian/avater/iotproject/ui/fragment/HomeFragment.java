package cn.zhian.avater.iotproject.ui.fragment;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import androidx.recyclerview.widget.LinearLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.ui.activity.DeviceManagerUI;
import cn.zhian.avater.iotproject.ui.activity.EnvirmentUI;
import cn.zhian.avater.iotproject.ui.activity.MessageUI;
import cn.zhian.avater.iotproject.ui.activity.VideoWatchUI;
import cn.zhian.avater.iotproject.utils.DataHelper;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.HomeAdapterItemSpace;
import cn.zhian.avater.iotproject.adapter.HomeRecylerViewAdapter;
import cn.zhian.avater.iotproject.base.BaseFragment;
import cn.zhian.avater.iotproject.bean.HomeRecylerViewBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-16 15:38
 * @Description:
 */
public class HomeFragment extends BaseFragment {


    @BindView(R.id.main_tv_tittle_home)
    TextView mainTvTittleHome;
    @BindView(R.id.main_tittle_iv_message)
    ImageView mainTittleIvMessage;
    @BindView(R.id.main_tittle_iv_global)
    ImageView mainTittleIvGlobal;
    @BindView(R.id.main_home_recycler_view)
    RecyclerView mainHomeRecyclerView;
    @BindView(R.id.main_home_ll_watch_speak)
    LinearLayout mainHomeLlWatchSpeak;
    @BindView(R.id.main_home_ll_environment_monitor)
    LinearLayout mainHomeLlEnvironmentMonitor;
    @BindView(R.id.main_home_ll_video_monitor)
    LinearLayout mainHomeLlVideoMonitor;
    @BindView(R.id.main_tittle_iv_message_dot)
    ImageView mainTittleIvMessageDot;

    private HomeRecylerViewAdapter adapter;
    private List<HomeRecylerViewBean> datas;

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public void initData() {
        mainTvTittleHome = null;
        datas = DataHelper.getHomeBeans(Applications.getPowerContext());
        adapter = new HomeRecylerViewAdapter(datas, getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mainHomeRecyclerView.setLayoutManager(manager);
        mainHomeRecyclerView.setAdapter(adapter);
        mainHomeRecyclerView.addItemDecoration(new HomeAdapterItemSpace(30, 0));
        adapter.setListener(listener);
    }

    private HomeRecylerViewAdapter.OnItemClickListener listener = position -> {
        switch (position) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
        }

    };


    @OnClick({R.id.main_tittle_iv_message, R.id.main_tittle_iv_global, R.id.main_home_ll_watch_speak, R.id.main_home_ll_environment_monitor, R.id.main_home_ll_video_monitor})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_tittle_iv_message:
                changUI(MessageUI.class);
                break;
            case R.id.main_tittle_iv_global:
                changUI(DeviceManagerUI.class);
                break;
            case R.id.main_home_ll_watch_speak:
                changUI(VideoWatchUI.class);
                break;
            case R.id.main_home_ll_environment_monitor:
                changUI(EnvirmentUI.class);
                break;
            case R.id.main_home_ll_video_monitor:
                changUI(VideoWatchUI.class);
                break;
        }
    }
}
