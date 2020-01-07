package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;

//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.AddHomeBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-25 16:10
 * @Description:
 */
public class CustomerAdapter extends RecyclerView.Adapter<CustomerAdapter.ViewHolder> {

    private Context mContext;
    private List<AddHomeBean> mDatas;

    public CustomerAdapter(Context mContext, List<AddHomeBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public CustomerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.customer_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomerAdapter.ViewHolder holder, int position) {
        AddHomeBean bean = mDatas.get(position);
        boolean select = bean.isSelect();
        holder.rb.setChecked(select);
        holder.rb.setOnClickListener(v -> {
            if (listener != null) {
                listener.click(!select, position);
            }
        });
        holder.icon.setImageResource(bean.getIconId());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private RadioButton rb;
        private ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rb = itemView.findViewById(R.id.rb);
            icon = itemView.findViewById(R.id.icon);
        }
    }

    private OnClick listener;

    public void setItemClickListener(OnClick clickListener) {
        listener = clickListener;
    }

    public interface OnClick {
        void click(boolean state, int position);
    }

}
