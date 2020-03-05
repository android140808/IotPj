package cn.zhian.avater.iotproject.adapter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

//import androidx.annotation.NonNull;
//import androidx.core.view.LayoutInflaterCompat;
//import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zhian.avater.databasemodule.tables.RoomDB;
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
    private List<RoomDB> roomDBList;
    private OnLongClick longClick;
    private OnClick onClick;

    public void setLongClick(OnLongClick longClick) {
        this.longClick = longClick;
    }

    public void setOnClick(OnClick onClick) {
        this.onClick = onClick;
    }

    public ControlAdapter(List<RoomDB> roomDBList, Context mContext) {
        this.roomDBList = roomDBList;
        this.mContext = mContext;
    }

 /*   public ControlAdapter(List<ControlBean> mData, Context mContext) {
        this.mData = mData;
        this.mContext = mContext;
    }*/

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.control_recyler_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void addRoom(RoomDB roomDB) {
        roomDBList.add(roomDB);
        notifyDataSetChanged();
    }

    public void addRoomAll(List<RoomDB> roomDB) {
        roomDBList.addAll(roomDB);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.content1.setVisibility(View.VISIBLE);
        holder.content2.setVisibility(View.VISIBLE);
        holder.content3.setVisibility(View.VISIBLE);
        RoomDB data = roomDBList.get(position);
        String roomName = data.getRoomName();
        int deviceCount = data.getDeviceCount();
        int icId = data.getChamIdentifier();//图标编号，本地和服务器都写死，对应上了就好
        int icIdRes = R.mipmap.room_1_3_8_11;
        switch (icId) {
            case 1:
            case 3:
            case 8:
            case 11:
                icIdRes = R.mipmap.room_1_3_8_11;
                break;
            case 2:
            case 19:
                icIdRes = R.mipmap.room_2_19_keting;
                break;
            case 4:
                icIdRes = R.mipmap.room_4_canting;
                break;
            case 5:
                icIdRes = R.mipmap.room_5_yangtai;
                break;
            case 6:
                icIdRes = R.mipmap.room_6_xuanguan;
                break;
            case 7:
            case 9:
            case 13:
                icIdRes = R.mipmap.room_7_9_13;
                break;
            case 10:
                icIdRes = R.mipmap.room_10_book;
                break;
            case 12:
                icIdRes = R.mipmap.room_12_gongju;
                break;
            case 14:
                icIdRes = R.mipmap.room_14_huike;
                break;
            case 15:
                icIdRes = R.mipmap.room_15_chucangshi;
                break;
            case 16:
                icIdRes = R.mipmap.room_16_yimaojian;
                break;
            case 17:
                icIdRes = R.mipmap.room_17_ertongfang;
                break;
            case 18:
                icIdRes = R.mipmap.room_18_lutai;
                break;
        }
        holder.tittleIv.setImageResource(icIdRes);
        holder.tittleTv.setText("" + roomName + "设备：");
        holder.tittleTvTotal.setText("" + deviceCount);
        String sensor = data.getSensor();//传感器
        String switchOffOn = data.getSwitchOffOn();//开关
        String elect = data.getElecttical();//家电
        Log.d("TAG", "sensor = " + sensor + ",position = " + position);
        Log.d("TAG", "switchOffOn = " + switchOffOn + ",position = " + position);
        Log.d("TAG", "elect = " + elect + ",position = " + position);
        if (TextUtils.isEmpty(sensor)) {
            holder.content1.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(switchOffOn)) {
            holder.content2.setVisibility(View.GONE);
        }
        if (TextUtils.isEmpty(elect)) {
            holder.content3.setVisibility(View.GONE);
        }
        holder.itemContent.setOnLongClickListener(v -> {
                    if (longClick != null) {
                        longClick.onLongClick(data, position);
                    }
                    return true;
                }
        );
        holder.itemContent.setOnClickListener(click -> {
            if (onClick != null) {
                onClick.onClick(data, position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return roomDBList.size();
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
        @BindView(R.id.item_content)
        LinearLayout itemContent;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public interface OnLongClick {
        void onLongClick(RoomDB data, int position);
    }

    public interface OnClick {
        void onClick(RoomDB data, int position);
    }
}
