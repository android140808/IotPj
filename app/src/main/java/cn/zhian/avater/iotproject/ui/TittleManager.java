package cn.zhian.avater.iotproject.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import cn.zhian.avater.iotproject.R;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-19 11:32
 * @Description: 顶部管理类
 * @Description: 每个UI都引用同一个布局，具体的显示由UI(Activity)控制即可
 * @Description: 后期改成Build模式
 */
public class TittleManager {

    private static TittleManager instance;
    private View view;
    private ImageView comm_tittle_iv_left;
    private ImageView comm_tittle_iv_right_img;
    private TextView comm_tittle_tv_middle_tittle;
    private TextView comm_tittle_tv_right;
    private OnClickListener leftIvListener;
    private OnClickListener rightIvListener;
    private OnClickListener rightTvListener;

    private TittleManager() {
    }

    public static TittleManager getInstance() {
        if (instance == null) {
            synchronized (TittleManager.class) {
                if (instance == null) {
                    instance = new TittleManager();
                }
            }
        }
        return instance;
    }

    public void initView(View view) {
        this.view = view;
        findViewById();
    }

    private void findViewById() {
        comm_tittle_iv_left = view.findViewById(R.id.comm_tittle_iv_left);
        comm_tittle_iv_right_img = view.findViewById(R.id.comm_tittle_iv_right_img);
        comm_tittle_tv_right = view.findViewById(R.id.comm_tittle_tv_right);
        comm_tittle_tv_middle_tittle = view.findViewById(R.id.comm_tittle_tv_middle_tittle);
    }

    private void setGoneAndClick() {
        comm_tittle_iv_left.setVisibility(View.GONE);
        comm_tittle_tv_middle_tittle.setVisibility(View.GONE);
        comm_tittle_iv_right_img.setVisibility(View.GONE);
        comm_tittle_tv_right.setVisibility(View.GONE);
        comm_tittle_iv_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (leftIvListener != null) {
                    leftIvListener.onClick();
                }
            }
        });
        comm_tittle_iv_right_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rightIvListener != null) {
                    rightIvListener.onClick();
                }
            }
        });
        comm_tittle_tv_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (rightTvListener != null) {
                    rightTvListener.onClick();
                }
            }
        });


    }

    public void setLeftIvListener(OnClickListener leftIvListener) {
        this.leftIvListener = leftIvListener;
    }

    public void setRightIvListener(OnClickListener rightIvListener) {
        this.rightIvListener = rightIvListener;
    }

    public void setRightTvListener(OnClickListener rightTvListener) {
        this.rightTvListener = rightTvListener;
    }

    public void showTittleOnly(int tittleId) {
        setGoneAndClick();
        comm_tittle_tv_middle_tittle.setVisibility(View.VISIBLE);
        comm_tittle_tv_middle_tittle.setText(tittleId);
    }

    public void showLeftIconAndTittle(int leftResId, int tittleId) {
        setGoneAndClick();
        comm_tittle_iv_left.setVisibility(View.VISIBLE);
        comm_tittle_iv_left.setBackgroundResource(leftResId);
        comm_tittle_tv_middle_tittle.setVisibility(View.VISIBLE);
        comm_tittle_tv_middle_tittle.setText(tittleId);
    }

    public void showTittleAndRightTv(int leftResId, int tittleId) {
        setGoneAndClick();
        comm_tittle_iv_left.setVisibility(View.VISIBLE);
        comm_tittle_iv_left.setBackgroundResource(leftResId);
        comm_tittle_tv_right.setVisibility(View.VISIBLE);
        comm_tittle_tv_right.setText(tittleId);
    }

    public void showTittleAndRightIv(int leftResId, int rightResId) {
        setGoneAndClick();
        comm_tittle_iv_left.setVisibility(View.VISIBLE);
        comm_tittle_iv_left.setBackgroundResource(leftResId);
        comm_tittle_iv_right_img.setVisibility(View.VISIBLE);
        comm_tittle_iv_right_img.setBackgroundResource(rightResId);
    }

    public void showAllIvAndTittle(int leftResId, int middleString, int rightResId) {
        setGoneAndClick();
        comm_tittle_iv_left.setVisibility(View.VISIBLE);
        comm_tittle_iv_left.setBackgroundResource(leftResId);
        comm_tittle_iv_right_img.setVisibility(View.VISIBLE);
        comm_tittle_iv_right_img.setBackgroundResource(rightResId);
        comm_tittle_tv_middle_tittle.setVisibility(View.VISIBLE);
        comm_tittle_tv_middle_tittle.setText(middleString);
    }

    public interface OnClickListener {
        void onClick();
    }

}
