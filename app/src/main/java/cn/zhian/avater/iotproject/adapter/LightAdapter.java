package cn.zhian.avater.iotproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.LightBean;

public class LightAdapter extends RecyclerView.Adapter<LightAdapter.ViewHolder> {

    private Context mContext;
    private List<LightBean> mDatas;
    private CallBack callBack;

    public LightAdapter(Context mContext, List<LightBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    public void setCallBackListener(CallBack listener) {
        callBack = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.light_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LightBean bean = mDatas.get(position);
        boolean switchState = bean.isSwitchState();
        boolean selectState = bean.isSelectState();
        if (switchState)
            holder.switchState.setChecked(true);
        else
            holder.switchState.setChecked(false);
        if (selectState)
            holder.rlBg.setBackgroundResource(R.drawable.light_item_1);
        else
            holder.rlBg.setBackgroundResource(R.drawable.light_item_0);
        String name = bean.getLightName();
        holder.switchName.setText(name);

//        holder.switchState.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (callBack != null) {
//                callBack.changeBg(position);
//            }
//        });
        holder.rlBg.setOnClickListener(click -> {
            if (callBack != null) {
                callBack.changeBg(position);
            }
        });
        holder.switchTime.setOnClickListener(click -> {
            if (callBack != null) {
                callBack.callBack(switchState, bean.getHour(), bean.getMinute(), bean.getSecond(), position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
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

    public interface CallBack {
        void callBack(boolean switchState, int hour, int minute, int second, int position);

        void changeBg(int position);
    }
}
