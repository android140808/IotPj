package cn.zhian.avater.iotproject.utils;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.bean.AddHomeBean;
import cn.zhian.avater.iotproject.bean.ControlBean;
import cn.zhian.avater.iotproject.bean.HomeRecylerViewBean;
import cn.zhian.avater.iotproject.bean.LeftBean;
import cn.zhian.avater.iotproject.bean.RightBean;

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
        HomeRecylerViewBean b4 = new HomeRecylerViewBean(3, context.getResources().getString(R.string.main_scenes_sleep), R.mipmap.item_sleep);
        data.add(b1);
        data.add(b2);
        data.add(b3);
        data.add(b4);
        return data;
    }

    public static List<LeftBean> getLeftData(Context context) {
        List<LeftBean> list = new ArrayList<>();
        list.add(new LeftBean(true, context.getResources().getString(R.string.device_lock)));
        list.add(new LeftBean(false, context.getResources().getString(R.string.device_switch)));
        list.add(new LeftBean(false, context.getResources().getString(R.string.device_control)));
//        list.add(new LeftBean(false, context.getResources().getString(R.string.device_manager_os)));
        list.add(new LeftBean(false, context.getResources().getString(R.string.device_environment)));
        list.add(new LeftBean(false, context.getResources().getString(R.string.device_security)));
        list.add(new LeftBean(false, context.getResources().getString(R.string.device_window)));
        return list;
    }

    public static List<RightBean> getRightData(Context context, int type) {
        List<RightBean> list = new ArrayList<>();
        switch (type) {
            case 0:
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.lock_t1), context.getResources().getString(R.string.lock_t1)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.lock_y1), context.getResources().getString(R.string.lock_y1)));
                break;
            case 1://kx
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.kx_1), context.getResources().getString(R.string.switch_1)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.kx_2), context.getResources().getString(R.string.switch_2)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.kx_3), context.getResources().getString(R.string.switch_3)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.kx_sense), context.getResources().getString(R.string.switch_sense)));
                break;
            case 6://ks
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.kx_1), context.getResources().getString(R.string.switch_1)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.kx_2), context.getResources().getString(R.string.switch_2)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.kx_3), context.getResources().getString(R.string.switch_3)));
                break;
            case 2:
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.switch_hp1), context.getResources().getString(R.string.control_hp1)));
                break;
            case 3:
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.environment_zg1), context.getResources().getString(R.string.environment_zg1)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.environment_gas), context.getResources().getString(R.string.environment_gas)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.environment_smoke), context.getResources().getString(R.string.environment_smoke)));
                break;
            case 4:
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.security_s1), context.getResources().getString(R.string.security_s1)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.security_human), context.getResources().getString(R.string.security_human)));
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.security_door_window), context.getResources().getString(R.string.security_door_window)));
                break;
            case 5:
                list.add(new RightBean(BitmapFactory.decodeResource(context.getResources(), R.mipmap.curtain_c1), context.getResources().getString(R.string.curtain_c1)));
                break;
        }
        return list;
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

    public static List<AddHomeBean> getHomeBean(Context context) {
        List<AddHomeBean> list = new ArrayList<>();
        list.add(new AddHomeBean(R.mipmap.add_home_often, R.string.room_often));
        list.add(new AddHomeBean(R.mipmap.bed_room, R.string.room_bedroom));
        list.add(new AddHomeBean(R.mipmap.item_go_home, R.string.room_living_room));
        list.add(new AddHomeBean(R.mipmap.bed_room, R.string.room_second_room));
        list.add(new AddHomeBean(R.mipmap.add_home_dining_room, R.string.room_dining));
        list.add(new AddHomeBean(R.mipmap.add_home_balcony, R.string.room_balcony));
        list.add(new AddHomeBean(R.mipmap.add_home_garden, R.string.room_garden));
        list.add(new AddHomeBean(R.mipmap.add_home_toilet, R.string.room_toilet));
        return list;
    }

    public static List<AddHomeBean> getIcons() {
        List<AddHomeBean> list = new ArrayList<>();
        list.add(new AddHomeBean(R.mipmap.bed_room, R.string.room_bedroom));
        list.add(new AddHomeBean(R.mipmap.item_go_home, R.string.room_living_room));
        list.add(new AddHomeBean(R.mipmap.bed_room, R.string.room_second_room));
        list.add(new AddHomeBean(R.mipmap.add_home_dining_room, R.string.room_dining));
        list.add(new AddHomeBean(R.mipmap.add_home_balcony, R.string.room_balcony));
        list.add(new AddHomeBean(R.mipmap.add_home_garden, R.string.room_garden));
        list.add(new AddHomeBean(R.mipmap.add_home_toilet, R.string.room_toilet));
        return list;
    }


    public static boolean isChinaPhone(String str) {
        String regExp = "^((13[0-9])|(15[^4])|(18[0-9])|(17[0-8])|(147,145))\\d{8}$";
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }

    public static int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }
}
