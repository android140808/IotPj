package cn.zhian.avater.iotproject.ui.activity;


import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.widget.MessageDotView;

public class MessageUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.security_destination)
    TextView securityDestination;
    @BindView(R.id.security_count)
    MessageDotView securityCount;
    @BindView(R.id.environment_destination)
    TextView environmentDestination;
    @BindView(R.id.environment_count)
    MessageDotView environmentCount;
    @BindView(R.id.pull_destination)
    TextView pullDestination;
    @BindView(R.id.pull_count)
    MessageDotView pullCount;
    @BindView(R.id.message_rl_security)
    RelativeLayout messageRlSecurity;
    @BindView(R.id.message_rl_environment)
    RelativeLayout messageRlEnvironment;
    @BindView(R.id.message_rl_pull)
    RelativeLayout messageRlPull;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.message_ui;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.message_total)
                .build();
    }

    @Override
    public void initData() {
        securityCount.setMessageCount(1);
        environmentCount.setMessageCount(21);
        pullCount.setMessageCount(11);
    }


    @OnClick({R.id.message_rl_security, R.id.message_rl_environment, R.id.message_rl_pull})
    public void onViewClicked(View view) {
        switch (view.getId()) {

            case R.id.message_rl_security:
                Bundle bundle = new Bundle();
                bundle.putInt("TAG", 0);
                changeUI(MessageUI.this, MessageContentUI.class, bundle);
                break;
            case R.id.message_rl_environment:
                Bundle bundle1 = new Bundle();
                bundle1.putInt("TAG", 1);
                changeUI(MessageUI.this, MessageContentUI.class, bundle1);
                break;
            case R.id.message_rl_pull:
                Bundle bundle2 = new Bundle();
                bundle2.putInt("TAG", 2);
                changeUI(MessageUI.this, MessageContentUI.class, bundle2);
                break;
        }
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
