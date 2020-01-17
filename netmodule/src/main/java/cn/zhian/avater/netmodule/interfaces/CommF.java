package cn.zhian.avater.netmodule.interfaces;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-10 10:29
 * @Description: 所有远程设备命令的基类
 */
public abstract class CommF {

    private String TAG = CommF.class.getSimpleName();
    private CallBack callBack;
    private byte commandCode;//命令码。是查询还是设置
    private byte action;//动作码。
    private byte[] contentLen = new byte[2];//长度
    private byte[] conent;//命令内容

    public CommF(CallBack callBack, byte commandCode, byte action) {
        this.callBack = callBack;
        this.commandCode = commandCode;
        this.action = action;
    }

    public byte getCommandCode() {
        return commandCode;
    }

    public void setCommandCode(byte commandCode) {
        this.commandCode = commandCode;
    }

    public byte getAction() {
        return action;
    }

    public void setAction(byte action) {
        this.action = action;
    }

    public byte[] getContentLen() {
        return contentLen;
    }

    public void setContentLen(byte[] contentLen) {
        this.contentLen = contentLen;
    }

    public byte[] getConent() {
        return conent;
    }

    public void setConent(byte[] conent) {
        this.conent = conent;
    }

    public void parseCommand(byte bytes[]) {

    }
}

