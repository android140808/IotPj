package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.Target;

import java.util.List;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.RightBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-25 16:10
 * @Description:
 */
public class RightAdapter extends RecyclerView.Adapter<RightAdapter.ViewHolder> {

    private Context mContext;
    private List<RightBean> mDatas;
    private int mCurrentType;//当前选项类型

    public RightAdapter(Context mContext, List<RightBean> mDatas) {
        this.mContext = mContext;
        this.mDatas = mDatas;
        mCurrentType = 0;
    }

    public void update(List<RightBean> data, int type) {
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
    public RightAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.right_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdapter.ViewHolder holder, int position) {
        RightBean bean = mDatas.get(position);
        //加载原图大小，不指定可能会被进行缩放
        RequestOptions options = new RequestOptions().override(Target.SIZE_ORIGINAL);
        //避免大图
        Glide.with(mContext).applyDefaultRequestOptions(options).load(bean.getBitmap()).into(holder.right_icon);
        //holder.right_icon.setImageBitmap(bean.getBitmap());
        holder.ll_view.setOnClickListener(view -> {
            if (listener != null) {
                listener.click(mCurrentType, position);
            }
        });
        holder.right_item.setText(bean.getDeviceName());
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private LinearLayout ll_view;
        private TextView right_item;
        private ImageView right_icon;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ll_view = itemView.findViewById(R.id.ll_view);
            right_item = itemView.findViewById(R.id.right_item);
            right_icon = itemView.findViewById(R.id.right_icon);
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
