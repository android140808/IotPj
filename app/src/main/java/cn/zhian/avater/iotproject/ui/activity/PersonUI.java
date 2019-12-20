package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class PersonUI extends BaseUI {


    @BindView(R.id.tittle_content)
    RelativeLayout tittleContent;
    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.comm_tittle_tv_middle_tittle)
    TextView commTittleTvMiddleTittle;
    @BindView(R.id.comm_tittle_iv_right_img)
    ImageView commTittleIvRightImg;

    @Override
    public int getViewLayout() {
        return R.layout.person_ui;
    }

    @Override
    public void findViewById() {
        commTittleIvLeft.setOnClickListener(v -> {
            closeUI();
        });
        commTittleIvRightImg.setOnClickListener(v -> {
        });
    }

    @Override
    public void initData() {

    }

}
