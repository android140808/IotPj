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

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.ControlBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-19 9:21
 * @Description:
 */
public class ControlAdapter extends RecyclerView.Adapter<ControlAdapter.ViewHolder> {

    private List<ControlBean> mData;
    private Context mContext;

    public ControlAdapter(List<ControlBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.control_recyler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ControlBean bean = mData.get(position);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.tittle_iv)
        ImageView tittleIv;
        @BindView(R.id.tittle_tv)
        TextView tittleTv;
        @BindView(R.id.tittle_tv_total)
        TextView tittleTvTotal;
        @BindView(R.id.content1)
        LinearLayout content1;
        @BindView(R.id.content2)
        LinearLayout content2;
        @BindView(R.id.content3)
        LinearLayout content3;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
