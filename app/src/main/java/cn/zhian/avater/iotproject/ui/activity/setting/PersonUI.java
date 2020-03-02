package cn.zhian.avater.iotproject.ui.activity.setting;

import android.content.ContentValues;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import cn.zhian.avater.databasemodule.MDB;
import cn.zhian.avater.databasemodule.tables.AccountDB;
import cn.zhian.avater.iotproject.R;
import cn.zhian.avater.iotproject.base.BasePresenter;
import cn.zhian.avater.iotproject.base.BaseUI;
import cn.zhian.avater.iotproject.ui.TittleManager;
import cn.zhian.avater.iotproject.utils.DialogUtils;
import cn.zhian.avater.iotproject.utils.GeneralMethods;
import cn.zhian.avater.netmodule.ServerRequest;
import cn.zhian.avater.netmodule.interfaces.NetResultCallBack;
import cn.zhian.avater.netmodule.mode.base.BaseResponse;
import cn.zhian.avater.netmodule.mode.requestBean.AccountRequest;
import cn.zhian.avater.netmodule.mode.responseBean.AccountResponse;

public class PersonUI extends BaseUI implements TittleManager.OnLeftClickListener, TittleManager.OnRightIvClickListener {


    @BindView(R.id.person_nickname)
    EditText nickName;
    @BindView(R.id.person_mobile)
    TextView mobile;

    private AccountDB accountDB;
    private String mCurrentNickName;

    @Override
    public BasePresenter createPresenter() {
        return null;
    }

    @Override
    public int getViewLayout() {
        return R.layout.person_ui;
    }

    @Override
    public void findViewById() {
        tittleManager = new TittleManager.Builder()
                .setView(findViewById(R.id.tittle_content))
                .setShowLeft(true)
                .setLeftIcon(R.mipmap.back)
                .setLeftListener(this)
                .setShowMiddle(true)
                .setMiddleRes(R.string.setting_personal)
                .setShowRightIv(true)
                .setRightIcon(R.mipmap.tittle_gou)
                .setRightIvListener(this)
                .build();
    }

    @Override
    public void initData() {
        if (!TextUtils.isEmpty(mCurrentPhoneNumber)) {
            accountDB = MDB.INSTANCE.getAccount(mCurrentPhoneNumber);
        }
        if (accountDB != null) {
            mCurrentNickName = accountDB.getNickname();
            mobile.setText(accountDB.getMobile());
            nickName.setText(accountDB.getNickname());
        }
    }

    @Override
    public void showLoading() {
        alertDialog = DialogUtils.getLoadDialog(this);
        alertDialog.show();
    }

    @Override
    public void onLeftClick() {
        closeUI();
    }

    @Override
    public void onRightIvClick() {
        if (!GeneralMethods.networkState(this)) {
            showToast(getResources().getString(R.string.login_network_error));
            return;
        }
        if (accountDB != null) {
            String name = nickName.getText().toString();
            if (name.equals(mCurrentNickName)) {
                showToast("保存成功！");
            }
            if (!TextUtils.isEmpty(name)) {
                AccountRequest request = new AccountRequest();
                request.setAvatar(accountDB.getAvatar());
                request.setCreatedTime(accountDB.getCreatedTime());
                request.setEmail(accountDB.getEmail());
                request.setEnabled(accountDB.isEnabled());
                request.setGatewayIp(accountDB.getGatewayIp());
                request.setId(accountDB.getAccountId());
                request.setLocked(accountDB.isLocked());
                request.setLastLoginIp(accountDB.getLastLoginIp());
                request.setLastLoginTime(accountDB.getLastLoginTime());
                request.setLoginCount(accountDB.getLoginCount());
                request.setLoginDevices(accountDB.getLoginDevices());
                request.setMobile(accountDB.getMobile());
                request.setNickname(name);
                request.setUpdatedTime(accountDB.getUpdatedTime());
                request.setUsername(accountDB.getUsername());
                request.setWeChat(accountDB.getWeChat());
                request.setWeChatUnionId(accountDB.getWeChatUnionId());
                showLoading();
                ServerRequest.INSTANCE.edidPerson(request, new NetResultCallBack<BaseResponse>() {
                    @Override
                    public void onSuccess(int responseCode, BaseResponse baseResponse) {
                        if (responseCode == 0) {
                            showMsg("修改个人信息成功");
                            ContentValues values = new ContentValues();
                            values.put("nickname", nickName.getText().toString());
                            MDB.INSTANCE.updateAccount(values);
                        }
                    }

                    @Override
                    public void onFail(int responseCode) {
                        showMsg("修改失败");
                    }
                });
            }
        }
    }

    private void showMsg(String msg) {
        showToast(msg);
        if (alertDialog != null) {
            alertDialog.dismiss();
            alertDialog = null;
        }
    }
}
