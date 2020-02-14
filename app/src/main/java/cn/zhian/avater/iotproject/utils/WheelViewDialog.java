package cn.zhian.avater.iotproject.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;

import java.util.ArrayList;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.ui.view.WheelView;

/**
 * @Author: wangweida
 * @CreateDate: 2020-02-14 9:41
 * @Description: 弹出选择框
 */
public class WheelViewDialog {
    private AlertDialog alertDialog;
    private WheelView wheelViewLeft;
    private WheelView wheelViewMiddle;
    private WheelView wheelViewRight;
    private TextView cancel;
    private TextView ok;
    private TextView tittle;
    private String leftSelectData = "";
    private String middleSelectData = "";
    private String rightSelectData = "";
    private Builder builder;


    private WheelViewDialog(Builder builder) {
        this.builder = builder;
        LayoutInflater inflater = (LayoutInflater) builder.context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.wheel_select, null, false);
        wheelViewLeft = view.findViewById(R.id.wheel_view_left);
        wheelViewMiddle = view.findViewById(R.id.wheel_view_middle);
        wheelViewRight = view.findViewById(R.id.wheel_view_right);
        cancel = view.findViewById(R.id.cancel);
        ok = view.findViewById(R.id.ok);
        tittle = view.findViewById(R.id.tittle);
        tittle.setText(builder.tittle);
        alertDialog = new AlertDialog.Builder(builder.context)
                .setView(view)
                .create();
        alertDialog.setCancelable(false);
        alertDialog.setCanceledOnTouchOutside(false);
        wheelViewLeft.setOnSelectListener(leftListener);
        wheelViewMiddle.setOnSelectListener(middleListener);
        wheelViewRight.setOnSelectListener(rightListener);
        if (builder.leftDatas != null && builder.leftDatas.size() > 0) {
            wheelViewLeft.setVisibility(View.VISIBLE);
            wheelViewLeft.setData(builder.leftDatas);
            wheelViewLeft.setDefault(builder.leftIndex);
            leftSelectData = builder.leftDatas.get(builder.leftIndex);
        } else {
            wheelViewLeft.setVisibility(View.GONE);
        }
        if (builder.middleDatas != null && builder.middleDatas.size() > 0) {
            wheelViewMiddle.setVisibility(View.VISIBLE);
            wheelViewMiddle.setData(builder.middleDatas);
            wheelViewMiddle.setDefault(builder.middleIndex);
            middleSelectData = builder.middleDatas.get(builder.middleIndex);
        } else {
            wheelViewMiddle.setVisibility(View.GONE);

        }
        if (builder.rightDatas != null && builder.rightDatas.size() > 0) {
            wheelViewRight.setVisibility(View.VISIBLE);
            wheelViewRight.setData(builder.rightDatas);
            wheelViewRight.setDefault(builder.rightIndex);
            rightSelectData = builder.rightDatas.get(builder.rightIndex);
        } else {
            wheelViewRight.setVisibility(View.GONE);
        }
        cancel.setOnClickListener(click -> {
            if (builder != null) {
                alertDialog.dismiss();
            }
        });

        ok.setOnClickListener(click -> {
            if (builder.leftListener != null) {
                builder.leftListener.onSelect(leftSelectData);
            }
            if (builder.middleListener != null) {
                builder.middleListener.onSelect(middleSelectData);
            }
            if (builder.rightListener != null) {
                builder.rightListener.onSelect(rightSelectData);
            }
            alertDialog.dismiss();
        });
    }

    public void show() {
        alertDialog.show();
    }

    private WheelView.OnSelectListener leftListener = new WheelView.OnSelectListener() {
        @Override
        public void endSelect(View view, int id, String text) {
            leftSelectData = text;
        }

        @Override
        public void selecting(int id, String text) {
        }
    };
    private WheelView.OnSelectListener middleListener = new WheelView.OnSelectListener() {
        @Override
        public void endSelect(View view, int id, String text) {
            middleSelectData = text;
        }

        @Override
        public void selecting(int id, String text) {
        }
    };
    private WheelView.OnSelectListener rightListener = new WheelView.OnSelectListener() {
        @Override
        public void endSelect(View view, int id, String text) {
            rightSelectData = text;
        }

        @Override
        public void selecting(int id, String text) {
        }
    };


    public static class Builder {
        private Context context;
        private OnSelectListener leftListener;
        private OnSelectListener middleListener;
        private OnSelectListener rightListener;
        private ArrayList<String> leftDatas;
        private ArrayList<String> middleDatas;
        private ArrayList<String> rightDatas;
        private int leftIndex;
        private int middleIndex;
        private int rightIndex;
        private String tittle = "";

        public WheelViewDialog build() {
            return new WheelViewDialog(this);
        }

        public Builder setTittle(String tittle) {
            this.tittle = tittle;
            return this;
        }

        public Builder setContext(Context context) {
            this.context = context;
            return this;
        }

        public Builder setLeftData(ArrayList<String> leftDatas) {
            this.leftDatas = leftDatas;
            return this;
        }

        public Builder setMiddleData(ArrayList<String> middleDatas) {
            this.middleDatas = middleDatas;
            return this;
        }

        public Builder setRightData(ArrayList<String> rightDatas) {
            this.rightDatas = rightDatas;
            return this;
        }

        public Builder setLeftListener(OnSelectListener leftListener) {
            this.leftListener = leftListener;
            return this;
        }

        public Builder setMiddleListener(OnSelectListener middleListener) {
            this.middleListener = middleListener;
            return this;
        }

        public Builder setRightListener(OnSelectListener rightListener) {
            this.rightListener = rightListener;
            return this;
        }

        public Builder setLeftIndex(int index) {
            this.leftIndex = index;
            return this;
        }

        public Builder setMiddleIndex(int index) {
            this.middleIndex = index;
            return this;
        }

        public Builder setRightIndex(int index) {
            this.rightIndex = index;
            return this;
        }

    }

    public interface OnSelectListener {
        void onSelect(String value);
    }

}
