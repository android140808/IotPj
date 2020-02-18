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
import cn.zhian.avater.iotproject.bean.MessageType;
import cn.zhian.avater.iotproject.widget.MessageDotView;

public class MessageUIAdapter extends RecyclerView.Adapter<MessageUIAdapter.ViewHolder> {

    private Context mContext;
    private List<MessageType> mDatas;
    private CommItemListener listener;

    public MessageUIAdapter(Context mContext, List<MessageType> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    public void updateList(int type, int count, String content) {
        switch (type) {
            case 0:
                mDatas.get(0).count = count;
                mDatas.get(0).detailString = content;
                break;
            case 1:
                mDatas.get(1).count = count;
                mDatas.get(1).detailString = content;
                break;
            case 2:
                mDatas.get(2).count = count;
                mDatas.get(2).detailString = content;
                break;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.message_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MessageType bean = mDatas.get(position);
        holder.content.setOnClickListener(click -> {
            if (listener != null) {
                listener.onItemClick(bean.type, position);
            }
        });
        holder.imageView.setBackground(mContext.getResources().getDrawable(bean.icon));
        holder.tittle.setText(mContext.getResources().getText(bean.tittleRes) + "");
        holder.detail.setText(bean.detailString + "");
        holder.count.setMessageCount(bean.count);
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

        private RelativeLayout content;
        private ImageView imageView;
        private TextView tittle;
        private TextView detail;
        private MessageDotView count;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            content = itemView.findViewById(R.id.message_content);
            imageView = itemView.findViewById(R.id.message_iv);
            tittle = itemView.findViewById(R.id.message_tittle);
            detail = itemView.findViewById(R.id.message_detail);
            count = itemView.findViewById(R.id.message_count);
        }
    }
}
