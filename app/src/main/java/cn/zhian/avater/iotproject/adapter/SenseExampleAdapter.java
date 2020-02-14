package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
public class SenseExampleAdapter extends RecyclerView.Adapter<SenseExampleAdapter.ViewHolder> {

    private Context mContext;
    private List<AddHomeBean> mDatas;

    public SenseExampleAdapter(Context mContext, List<AddHomeBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
    }

    @NonNull
    @Override
    public SenseExampleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.sense_example_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SenseExampleAdapter.ViewHolder holder, int position) {
        AddHomeBean bean = mDatas.get(position);
        holder.icon.setImageResource(bean.getIconId());
        if (listener != null) {
            holder.icon.setOnClickListener(onclick -> listener.click(true, position));
        }
        holder.name.setText(bean.getName());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private ImageView icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
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
