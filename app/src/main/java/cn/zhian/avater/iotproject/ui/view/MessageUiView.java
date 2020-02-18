package cn.zhian.avater.iotproject.ui.view;

import cn.zhian.avater.iotproject.base.BaseView;

public interface MessageUiView extends BaseView {
    void closeDialog();

    void updateMessageCount(int type, int count, String firstContent);
}
