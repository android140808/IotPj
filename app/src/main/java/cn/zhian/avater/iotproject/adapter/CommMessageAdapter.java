package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.CommMessageBean;

public class CommMessageAdapter extends RecyclerView.Adapter<CommMessageAdapter.ViewHolder> {

    private Context mContext;
    private List<CommMessageBean> mDatas;
    private CommItemListener listener;

    public CommMessageAdapter(Context mContext, List<CommMessageBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.message_adapter_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CommMessageBean bean = mDatas.get(position);
        boolean state = bean.isRead;
        holder.message_state_iv.setVisibility(state ? View.GONE : View.VISIBLE);
        holder.message_tittle_tv.setText(bean.tittle);
        holder.message_detail_tv.setText(bean.detail);
        holder.message_date_tv.setText(bean.date);
        holder.message_content.setOnClickListener(view -> {
            if (listener != null) {
                listener.onItemClick(bean.type, position);
            }
        });

    }

    public void setItemListener(CommItemListener listener) {
        this.listener = listener;
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private RelativeLayout message_content;
        private ImageView message_state_iv;
        private TextView message_tittle_tv;
        private TextView message_detail_tv;
        private TextView message_date_tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            message_content = itemView.findViewById(R.id.message_content);
            message_state_iv = itemView.findViewById(R.id.message_state_iv);
            message_tittle_tv = itemView.findViewById(R.id.message_tittle_tv);
            message_detail_tv = itemView.findViewById(R.id.message_detail_tv);
            message_date_tv = itemView.findViewById(R.id.message_date_tv);
        }
    }
}
