package cn.zhian.avater.iotproject.ui.activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;

public class MessageDetailUI extends BaseUI implements TittleManager.OnLeftClickListener {

    @BindView(R.id.tittle)
    TextView tittle;
    @BindView(R.id.date)
    TextView date;
    @BindView(R.id.content)
    TextView content;
    @BindView(R.id.icon)
    ImageView icon;

    private String tittleString;
    private String dateString;
    private String contentString;


    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.message_detail_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.message_detail)
                .build();
    }

    @Override
    public void initData() {
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            tittleString = extras.getString("tittle");
            dateString = extras.getString("date");
            contentString = extras.getString("content");
        }
        tittle.setText("" + tittleString);
        date.setText("" + dateString);
        content.setText("" + contentString);
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

}
