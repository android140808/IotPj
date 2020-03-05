package cn.zhian.avater.iotproject.ui.activity.control;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.ImageView;

//import androidx.recyclerview.widget.GridLayoutManager;
//import androidx.recyclerview.widget.RecyclerView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.adapter.AddRoomAdapter;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.bean.AddHomeBean;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DataHelper;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.AddRoomRequest;

public class AddNewRoomUI extends BaseUI implements TittleManager.OnLeftClickListener {


    @BindView(R.id.comm_tittle_iv_left)
    ImageView commTittleIvLeft;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    private AddRoomAdapter addRoomAdapter;
    private List<AddHomeBean> mData;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.add_new_room_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.add_new_room)
                .build();
    }

    @Override
    public void initData() {
        mData = DataHelper.getHomeBean(this);
        addRoomAdapter = new AddRoomAdapter(this, mData);
        GridLayoutManager manager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(addRoomAdapter);
        addRoomAdapter.setItemClickListener(onClick);

       /* try {
            String fileName1 = Environment.getDataDirectory().getAbsolutePath() + File.separator + "zhi_an";
            Log.e("TAG", "fileName1 = " + fileName1);
            File parentFile = new File(fileName1);
            if (!parentFile.exists()) {
                parentFile.mkdirs();
            }
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.curtain_c1);
            saveImageToGallery(bitmap);
//            String picName = fileName1 + File.separator + System.currentTimeMillis() + ".png";
//            File newFile = new File(picName);
//            FileOutputStream fos = new FileOutputStream(newFile);
//            bitmap.compress(Bitmap.CompressFormat.PNG, 90, fos);
//            fos.flush();
//            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    public int saveImageToGallery(Bitmap bmp) {
        //生成路径
//        String root2 = getExternalFilesDir(Environment.DIRECTORY_PICTURES).getAbsolutePath();//应用内置存储路径
        String root = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "zhi_an" + File.separator;
        String dirName = "AA11";
        File appDir = new File(root, dirName);
        if (!appDir.exists()) {
            appDir.mkdirs();
        }
        //文件名为时间
        long timeStamp = System.currentTimeMillis();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String sd = sdf.format(new Date(timeStamp));
        String fileName = sd + ".png";
        //获取文件
        File file = new File(appDir, fileName);
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fos);
            fos.flush();
            //通知系统相册刷新
//            ImageActivity.this.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
//                    Uri.fromFile(new File(file.getPath()))));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        AddRoomRequest request = new AddRoomRequest("厨房", accountDB.getAccountId(), 13);
        ServerRequest.INSTANCE.addRoom(request, null, new NetResultCallBack<BaseResponse>() {
            @Override
            public void onSuccess(int responseCode, BaseResponse baseResponse) {

            }

            @Override
            public void onFail(int responseCode) {

            }
        });
        return -1;
    }

    private AddRoomAdapter.OnClick onClick = (type, position) -> {
        if (position == 0) {
            changeUI(AddNewRoomUI.this, CustomerRoomUI.class);
        } else {
            AddHomeBean bean = mData.get(position);
            Bundle bundle = new Bundle();
            bundle.putString("tittle", bean.getName());
//            changeUI(AddNewRoomUI.this, AddDeviceUI.class, bundle);
            changeUI(AddNewRoomUI.this, AddDetailRoomUI.class, bundle);
        }
        long id = 0;
        if (accountDB != null) {
            id = accountDB.getAccountId();
        }
//        AddRoomRequest request = new AddRoomRequest("卧室", id);
//        ServerRequest.INSTANCE.addRoom(request,);
    };

    @Override
    public void showLoading() {

    }

    @Override
    public void onLeftClick() {
        closeUI();
    }
}
