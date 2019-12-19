package cn.zhian.avater.iotproject.ui.fragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.Applications;
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

    private HomeRecylerViewAdapter adapter;
    private List<HomeRecylerViewBean> datas;

    @Override
    public int getLayout() {
        return R.layout.fragment_home;
    }

    @Override
    public void initData() {
        datas = DataHelper.getHomeBeans(Applications.getPowerContext());
        adapter = new HomeRecylerViewAdapter(datas, getActivity());
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        manager.setOrientation(LinearLayoutManager.HORIZONTAL);
        mainHomeRecyclerView.setLayoutManager(manager);
        mainHomeRecyclerView.setAdapter(adapter);
        mainHomeRecyclerView.addItemDecoration(new HomeAdapterItemSpace(30, 0));
        adapter.setListener(listener);
    }

    private HomeRecylerViewAdapter.OnItemClickListener listener = new HomeRecylerViewAdapter.OnItemClickListener() {
        @Override
        public void onClick(int position) {
            switch (position) {
                case 0:
                    showToast("1");
                    break;
                case 1:
                    showToast("2");
                    break;
                case 2:
                    showToast("3");
                    break;
                case 3:
                    showToast("4");
                    break;
            }

        }
    };


    @OnClick({R.id.main_tittle_iv_message, R.id.main_tittle_iv_global})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.main_tittle_iv_message:
                break;
            case R.id.main_tittle_iv_global:
                break;
        }
    }
}
