package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.AddHomeBean;
import cn.zhian.avater.iotproject.bean.RightBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-25 16:10
 * @Description:
 */
public class AddRoomAdapter extends RecyclerView.Adapter<AddRoomAdapter.ViewHolder> {

    private Context mContext;
    private List<AddHomeBean> mDatas;
    private int mCurrentType;//当前选项类型

    public AddRoomAdapter(Context mContext, List<AddHomeBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mCurrentType = 0;
    }

    public void update(List<AddHomeBean> data, int type) {
        mDatas = data;
        mCurrentType = type;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @NonNull
    @Override
    public AddRoomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.add_room_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AddRoomAdapter.ViewHolder holder, int position) {
        AddHomeBean rightBean = mDatas.get(position);
        holder.icon.setImageResource(rightBean.getIconId());
        holder.name.setText(rightBean.getName());
        holder.ll_view.setOnClickListener(view -> {
            if (listener != null) {
                listener.click(mCurrentType, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView icon;
        private TextView name;
        private LinearLayout ll_view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon = itemView.findViewById(R.id.icon);
            name = itemView.findViewById(R.id.name);
            ll_view = itemView.findViewById(R.id.ll_view);
        }
    }

    private OnClick listener;

    public void setItemClickListener(OnClick clickListener) {
        listener = clickListener;
    }

    public interface OnClick {
        void click(int dataType, int position);
    }

}
