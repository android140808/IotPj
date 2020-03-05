package cn.zhian.avater.iotproject.ui.presenter;

import android.content.Context;

import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.ui.model.ControlModel;
import cn.zhian.avater.iotproject.ui.view.ControlView;
import cn.zhian.avater.iotproject.utils.GeneralMethods;

/**
 * Date：2020/3/4
 * Author:Avater
 * Description:
 */
public class ControlPresenter implements BasePresenter<ControlView> {

    private ControlView view;
    private ControlModel model;


    @Override
    public void attachView(ControlView view) {
        this.view = view;
        model = new ControlModel();
    }

    public void getAllRoom(Context context, String mobile, long accountId) {
        if (!GeneralMethods.networkState(context)) {
            view.getRoomDBList(MDB.INSTANCE.getAllRoom(mobile, accountId));
            return;
        }

        model.getAllRoomAndDevice(mobile, accountId, list -> {
            view.getRoomDBList(list);
        });
    }

    @Override
    public void onDestroy() {
        view = null;
    }
}
