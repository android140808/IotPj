package cn.zhian.avater.netmodule.utils;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date：2020/3/3
 * Author:Avater
 * Description:
 */
public class FileUtils {
    public static boolean createFile(Activity ui, String name) {
        String root = Environment.getExternalStorageDirectory().getAbsolutePath()
                + File.separator + "ZhianTech" + File.separator;
        String fileName = "Pics";
        File dir = new File(root, fileName);
        if (!dir.exists()) {
            dir.mkdirs();
        }
        long timeStmp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd HH:mm:ss");
        String date = sdf.format(new Date(timeStmp));
        String picName = date+".png";
        File picFile = new File(dir,picName);

        return false;
    }
}
