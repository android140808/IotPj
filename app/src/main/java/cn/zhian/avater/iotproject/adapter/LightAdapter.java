package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.AddHomeBean;

public class LightAdapter extends RecyclerView.Adapter {
    private Context mContext;
    private List<AddHomeBean> mDatas;

    public LightAdapter(Context mContext, List<AddHomeBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.light_item, parent, false);
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.switch_state)
        Switch switchState;
        @BindView(R.id.switch_name)
        TextView switchName;
        @BindView(R.id.rl_bg)
        RelativeLayout rlBg;
        @BindView(R.id.switch_time)
        Button switchTime;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
