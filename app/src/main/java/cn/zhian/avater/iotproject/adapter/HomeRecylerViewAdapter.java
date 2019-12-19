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

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.HomeRecylerViewBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-18 14:46
 * @Description:
 */
public class HomeRecylerViewAdapter extends RecyclerView.Adapter<HomeRecylerViewAdapter.ViewHolder> {

    private List<HomeRecylerViewBean> mList;
    private Context mContext;
    private OnItemClickListener listener;

    public HomeRecylerViewAdapter(List<HomeRecylerViewBean> mList, Context context) {
        this.mList = mList;
        mContext = context;
    }

    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.home_recyler_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        HomeRecylerViewBean bean = mList.get(position);
        holder.imageView.setBackgroundResource(bean.getResId());
        holder.textView.setText(bean.getModeName());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onClick(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageView;
        private TextView textView;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.item_iv);
            textView = itemView.findViewById(R.id.item_tv);
            linearLayout = itemView.findViewById(R.id.item_ll);
        }

    }

    public static interface OnItemClickListener {
        void onClick(int position);
    }
}
