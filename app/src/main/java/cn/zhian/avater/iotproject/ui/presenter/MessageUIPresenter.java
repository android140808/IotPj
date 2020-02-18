package cn.zhian.avater.iotproject.ui.presenter;

import java.util.List;

import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseView;
import cn.zhian.avater.iotproject.ui.model.MessageUIModel;
import cn.zhian.avater.iotproject.ui.view.MessageUiView;
import cn.zhian.avater.netmodule.mode.responseBean.CommMessageResponse;

public class MessageUIPresenter<V extends BaseView> implements BasePresenter<V> {

    private MessageUiView view;
    private MessageUIModel model;
    private List<CommMessageResponse.Data> listSecurity;
    private List<CommMessageResponse.Data> listPush;
    private List<CommMessageResponse.Data> listEnvironment;
    private int currentPageSecurity = 0;
    private int currentPagePush = 0;
    private int currentPageEnvironment = 0;
    private int commPageSize = 10;

    public List<CommMessageResponse.Data> getListSecurity() {
        return listSecurity;
    }

    public List<CommMessageResponse.Data> getListPush() {
        return listPush;
    }

    public List<CommMessageResponse.Data> getListEnvironment() {
        return listEnvironment;
    }

    public int getCurrentPagePush() {
        return currentPagePush;
    }

    public int getCurrentPageEnvironment() {
        return currentPageEnvironment;
    }

    public int getCommPageSize() {
        return commPageSize;
    }

    public MessageUIPresenter() {
        this.model = new MessageUIModel();
    }

    @Override
    public void attachView(V view) {
        this.view = (MessageUiView) view;
    }

    private synchronized void getCountAndFirstContent(int type, List<CommMessageResponse.Data> data) {
        if (data == null) {
            return;
        }
        int count = 0;
        String msg = "新的消息";
        for (CommMessageResponse.Data bean : data) {
            String isRead = bean.getIsRead();
            if (isRead.equals("1")) {//1 未读，0已读
                if (count == 0) {
                    msg = bean.getContent();
                }
                count++;
            }
        }
        if (view != null)
            view.updateMessageCount(type, count, msg);
    }

    public void getAllMessage(int currentPage, int pageSize) {
        if (view == null) return;
        model.getMessageSecurity(currentPage, pageSize, list -> {
            if (list == null) {
                return;
            }
            view.closeDialog();
            getCountAndFirstContent(0, list);
            listSecurity = list;
        });
        model.getMessagePush(currentPage, pageSize, list -> {
            if (list == null) {
                return;
            }
            getCountAndFirstContent(2, list);
            view.closeDialog();
            listPush = list;
        });
        model.getMessageEnvironment(currentPage, pageSize, list -> {
            if (list == null) {
                return;
            }
            view.closeDialog();
            getCountAndFirstContent(1, list);
            listEnvironment = list;
        });
    }

    public void getMessageSecurity(int currentPage, int pageSize) {
        if (view == null) return;
        currentPageSecurity = currentPage;
        model.getMessageSecurity(currentPage, pageSize, list -> {
            if (list != null) {
                listSecurity.addAll(list);
            }
            view.closeDialog();
        });

    }

    public void getMessagePush(int currentPage, int pageSize) {
        if (view == null) return;
        currentPagePush = currentPage;
        model.getMessagePush(currentPage, pageSize, list -> {
            if (list != null) {
                listPush.addAll(list);
            }
            view.closeDialog();
        });

    }

    public void getMessageEnvironment(int currentPage, int pageSize) {
        if (view == null) return;
        currentPageEnvironment = currentPage;
        model.getMessageEnvironment(currentPage, pageSize, list -> {
            if (list != null) {
                listEnvironment.addAll(list);
            }
            view.closeDialog();

        });
    }

    @Override
    public void onDestroy() {
        view = null;
    }

}
