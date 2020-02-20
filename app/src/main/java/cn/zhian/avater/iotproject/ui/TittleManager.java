package cn.zhian.avater.iotproject.ui;

import android.annotation.TargetApi;
import android.os.Build;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.RequiresApi;

import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.utils.BuglyHelp;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-19 11:32
 * @Description: 顶部管理类
 * @Description: 每个UI都引用同一个布局，具体的显示由UI 控制即可
 */
public class TittleManager implements View.OnClickListener {

    private View view;
    private ImageView comm_tittle_iv_left;
    private ImageView comm_tittle_iv_right_img;
    private TextView comm_tittle_tv_middle_tittle;
    private TextView comm_tittle_tv_right;
    private OnLeftClickListener leftIvListener;
    private OnRightIvClickListener rightIvListener;
    private OnRightTvClickListener rightTvListener;


    private TittleManager(Builder builder) {
        this.view = builder.view;
        initView(view);
        setLeftIvListener(builder.leftIvListener);
        setRightIvListener(builder.rightIvListener);
        setRightTvListener(builder.rightTvListener);
        setTittleState(
                builder.showLeft, builder.leftIcon,
                builder.showMiddle, builder.middleRes, builder.middleResString,
                builder.showRightTv, builder.rightRes, builder.rightTvColor,
                builder.showRightIv, builder.rightIcon
        );
    }

    public void initView(View view) {
        this.view = view;
        comm_tittle_iv_left = view.findViewById(R.id.comm_tittle_iv_left);
        comm_tittle_iv_right_img = view.findViewById(R.id.comm_tittle_iv_right_img);
        comm_tittle_tv_right = view.findViewById(R.id.comm_tittle_tv_right);
        comm_tittle_tv_middle_tittle = view.findViewById(R.id.comm_tittle_tv_middle_tittle);
        comm_tittle_iv_left.setOnClickListener(this);
        comm_tittle_iv_right_img.setOnClickListener(this);
        comm_tittle_tv_right.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.comm_tittle_iv_left:
                if (leftIvListener != null) {
                    leftIvListener.onLeftClick();
                }
                break;
            case R.id.comm_tittle_iv_right_img:
                if (rightIvListener != null) {
                    rightIvListener.onRightIvClick();
                }
                break;
            case R.id.comm_tittle_tv_right:
                if (rightTvListener != null) {
                    rightTvListener.onRightTvClick();
                }
                break;
        }
    }


    @TargetApi(Build.VERSION_CODES.M)
    public void setTittleState(boolean left, int icon, boolean middle, int strRes, String middleString, boolean rightTv, int strTv, int rightTvColor, boolean rightIv, int iconRight) {
        try {
            comm_tittle_iv_left.setVisibility(left ? View.VISIBLE : View.GONE);
            if (left) {
                comm_tittle_iv_left.setImageResource(icon);
            }
            comm_tittle_tv_middle_tittle.setVisibility(middle ? View.VISIBLE : View.GONE);
            if (strRes == 0 || strRes == -1) {
                if (!TextUtils.isEmpty(middleString))
                    comm_tittle_tv_middle_tittle.setText(middleString);
                else
                    comm_tittle_tv_middle_tittle.setText("");
            } else
                comm_tittle_tv_middle_tittle.setText(Applications.getPowerContext().getResources().getString(strRes));

            comm_tittle_tv_right.setVisibility(rightTv ? View.VISIBLE : View.GONE);
            if (strTv == 0 || strTv == -1) {
                comm_tittle_tv_right.setText("");
            } else {
                String s = Applications.getPowerContext().getResources().getString(strTv);
                comm_tittle_tv_right.setText(s);
                comm_tittle_tv_right.setTextColor(Applications.getPowerContext().getColor(rightTvColor));
            }
            comm_tittle_iv_right_img.setVisibility(rightIv ? View.VISIBLE : View.GONE);
            if (rightIv) {
                comm_tittle_iv_right_img.setImageResource(iconRight);
            }
        } catch (Exception e) {
            e.printStackTrace();
            BuglyHelp.reportE(e, Thread.currentThread());
        }
    }


    public void setLeftIvListener(OnLeftClickListener leftIvListener) {
        this.leftIvListener = leftIvListener;
    }

    public void setRightIvListener(OnRightIvClickListener rightIvListener) {
        this.rightIvListener = rightIvListener;
    }

    public void setRightTvListener(OnRightTvClickListener rightTvListener) {
        this.rightTvListener = rightTvListener;
    }

    public interface OnLeftClickListener {
        void onLeftClick();
    }

    public interface OnRightTvClickListener {
        void onRightTvClick();
    }

    public interface OnRightIvClickListener {
        void onRightIvClick();
    }

    public static class Builder {
        private View view;
        private boolean showLeft;
        private int leftIcon;
        private boolean showMiddle;
        private int middleRes;
        private String middleResString;
        private boolean showRightTv;
        private int rightRes;
        private boolean showRightIv;
        private int rightIcon;
        private int rightTvColor;

        private OnLeftClickListener leftIvListener;
        private OnRightIvClickListener rightIvListener;
        private OnRightTvClickListener rightTvListener;

        public Builder setView(View view) {
            this.view = view;
            return this;
        }

        public Builder setRightTvColor(int color) {
            this.rightTvColor = color;
            return this;
        }

        public Builder setShowLeft(boolean showLeft) {
            this.showLeft = showLeft;
            return this;
        }

        public Builder setLeftIcon(int leftIcon) {
            this.leftIcon = leftIcon;
            return this;
        }

        public Builder setShowMiddle(boolean showMiddle) {
            this.showMiddle = showMiddle;
            return this;
        }

        public Builder setMiddleRes(int middleRes) {
            this.middleRes = middleRes;
            return this;
        }

        public Builder setMiddleResString(String middleRes) {
            this.middleResString = middleRes;
            return this;
        }

        public Builder setShowRightTv(boolean showRightTv) {
            this.showRightTv = showRightTv;
            return this;
        }

        public Builder setRightRes(int rightRes) {
            this.rightRes = rightRes;
            return this;
        }

        public Builder setShowRightIv(boolean showRightIv) {
            this.showRightIv = showRightIv;
            return this;
        }

        public Builder setRightIcon(int rightIcon) {
            this.rightIcon = rightIcon;
            return this;
        }

        public TittleManager build() {
            return new TittleManager(this);
        }

        public Builder setLeftListener(OnLeftClickListener leftIvListener) {
            this.leftIvListener = leftIvListener;
            return this;
        }

        public Builder setRightIvListener(OnRightIvClickListener rightIvListener) {
            this.rightIvListener = rightIvListener;
            return this;
        }

        public Builder setRightTvListener(OnRightTvClickListener rightTvListener) {
            this.rightTvListener = rightTvListener;
            return this;
        }

    }

}
