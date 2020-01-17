package cn.zhian.avater.iotproject.wxapi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.alibaba.fastjson.JSON;
import com.tencent.mm.opensdk.constants.ConstantsAPI;
import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

import org.greenrobot.eventbus.EventBus;

import cn.zhian.avater.iotproject.Applications;
import cn.zhian.avater.iotproject.eventbus.WeChatLoginBus;
import cn.zhian.avater.iotproject.utils.LogUtil;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-15 9:13
 * @Description: 微信登录回调
 */
public class WXEntryActivity extends Activity implements IWXAPIEventHandler {

    private IWXAPI iwxapi;
    private String TAG = WXEntryActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LogUtil.e(TAG, "微信界面调起");
        iwxapi = WXAPIFactory.createWXAPI(this, Applications.WE_CHAT_C_K, true);
        iwxapi.registerApp(Applications.WE_CHAT_C_K);
        //第三方开发者如果使用透明界面来实现WXEntryActivity，需要判断handleIntent的返回值，
        // 如果返回值为false，则说明入参不合法未被SDK处理，应finish当前透明界面，
        // 避免外部通过传递非法参数的Intent导致停留在透明界面，引起用户的疑惑
        try {
            boolean state = iwxapi.handleIntent(getIntent(), this);
            if (!state) {
                finish();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        LogUtil.e(TAG, "onResp()");
        if (baseResp != null) {
            String msg = "微信登录失败，请重试！";
            switch (baseResp.errCode) {
                case BaseResp.ErrCode.ERR_OK://登录成功
                    if (baseResp.getType() == ConstantsAPI.COMMAND_SENDAUTH) {
                        msg = "登录成功！";
                        WeChatLoginBus bus = JSON.parseObject(JSON.toJSONString(baseResp), WeChatLoginBus.class);
                        EventBus.getDefault().post(bus);
                    }
                    break;
                /*case BaseResp.ErrCode.ERR_COMM:
                    break;
                case BaseResp.ErrCode.ERR_USER_CANCEL:
                    break;
                case BaseResp.ErrCode.ERR_SENT_FAILED:
                    break;
                case BaseResp.ErrCode.ERR_AUTH_DENIED:
                    break;
                case BaseResp.ErrCode.ERR_UNSUPPORT:
                    break;*/
                case BaseResp.ErrCode.ERR_BAN:
                    msg = "签名错误！";
                    break;
                default:
                    msg = "微信登录失败，请重试！";
                    break;
            }
            Toast.makeText(WXEntryActivity.this, "" + msg, Toast.LENGTH_SHORT).show();
            finish();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        iwxapi.handleIntent(data, this);
        LogUtil.e(TAG, "onActivityResult");
    }
}
