package cn.zhian.avater.iotproject.bean;

public class MessageType {
    public int type;
    public int icon;
    public int tittleRes;
    public String detailString;
    public int count;


    public MessageType(int type, int icon, int tittleRes, String detailString, int count) {
        this.type = type;
        this.icon = icon;
        this.tittleRes = tittleRes;
        this.detailString = detailString;
        this.count = count;
    }
}
