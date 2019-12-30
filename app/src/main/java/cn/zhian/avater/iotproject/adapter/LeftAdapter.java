package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.LeftBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-25 16:10
 * @Description:
 */
public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.ViewHolder> {

    private Context mContext;
    private List<LeftBean> mDatas;

    public LeftAdapter(Context mContext, List<LeftBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public LeftAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.left_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.ViewHolder holder, int position) {
        LeftBean bean = mDatas.get(position);
        holder.item.setText(bean.getType());
        if (bean.isSelect()) {
            holder.ll_view.setBackgroundResource(R.color.color_bg);
        } else {
            holder.ll_view.setBackgroundResource(R.color.color_while);
        }
        holder.ll_view.setOnClickListener(view -> {
            if (listener != null) {
                listener.click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView item;
        private LinearLayout ll_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item = itemView.findViewById(R.id.item);
            ll_view = itemView.findViewById(R.id.ll_view);
        }
    }

    private OnClick listener;

    public void setItemClickListener(OnClick clickListener) {
        listener = clickListener;
    }

    public interface OnClick {
        void click(int position);
    }

}
