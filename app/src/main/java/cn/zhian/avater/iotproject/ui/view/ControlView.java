package cn.zhian.avater.iotproject.ui.view;

import java.util.List;

import cn.zhian.avater.databasemodule.tables.RoomDB;
import cn.zhian.avater.iotproject.base.BaseView;

/**
 * Date：2020/3/4
 * Author:Avater
 * Description:
 */
public interface ControlView extends BaseView {
    void getRoomDBList(List<RoomDB> list);
}
