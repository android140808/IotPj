package cn.zhian.avater.iotproject.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import cn.zhian.avater.iotproject.R;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-10 10:06
 * @Description:
 */
public class EnvirAdapter extends RecyclerView.Adapter<EnvirAdapter.ViewHolder> {


    private Context mContext;


    @NonNull
    @Override
    public EnvirAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(mContext, R.layout.envir_item, parent);
        EnvirAdapter.ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull EnvirAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView iv;
        private TextView tv;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
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
