package cn.zhian.avater.iotproject.utils;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.ControlBean;
import cn.zhian.avater.iotproject.bean.HomeRecylerViewBean;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-18 15:01
 * @Description:
 */
public class DataHelper {
    public static List<HomeRecylerViewBean> getHomeBeans(Context context) {
        List<HomeRecylerViewBean> data = new ArrayList<>();
        HomeRecylerViewBean b1 = new HomeRecylerViewBean(0, context.getResources().getString(R.string.main_scenes_leave_home), R.mipmap.item_leave_home);
        HomeRecylerViewBean b2 = new HomeRecylerViewBean(1, context.getResources().getString(R.string.main_scenes_go_home), R.mipmap.item_go_home);
        HomeRecylerViewBean b3 = new HomeRecylerViewBean(2, context.getResources().getString(R.string.main_scenes_safe), R.mipmap.item_safe);
        HomeRecylerViewBean b4 = new HomeRecylerViewBean(3, context.getResources().getString(R.string.main_scenes_sleep), R.mipmap.item_leave_home);
        data.add(b1);
        data.add(b2);
        data.add(b3);
        data.add(b4);
        return data;
    }

    public static List<ControlBean> getControlBeans(Context context) {
        List<ControlBean> list = new ArrayList<>();
        ControlBean c1 = new ControlBean(3, context.getResources().getString(R.string.control_bed_room), R.mipmap.bed_room, context.getResources().getString(R.string.control_security_sense), 1, context.getResources().getString(R.string.control_linght_sense), 1, context.getResources().getString(R.string.control_encironment_sense), 1);
        ControlBean c2 = new ControlBean(3, context.getResources().getString(R.string.control_living_room), R.mipmap.bed_room, context.getResources().getString(R.string.control_security_sense), 1, context.getResources().getString(R.string.control_linght_sense), 1, context.getResources().getString(R.string.control_encironment_sense), 1);
        ControlBean c3 = new ControlBean(3, context.getResources().getString(R.string.control_balcony), R.mipmap.bed_room, context.getResources().getString(R.string.control_security_sense), 1, context.getResources().getString(R.string.control_linght_sense), 1, context.getResources().getString(R.string.control_encironment_sense), 1);
        list.add(c1);
        list.add(c2);
        list.add(c3);
        return list;
    }
}
