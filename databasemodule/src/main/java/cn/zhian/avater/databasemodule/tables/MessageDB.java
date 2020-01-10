package cn.zhian.avater.databasemodule.tables;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/**
 * @Author: wangweida
 * @CreateDate: 2020-01-09 9:38
 * @Description:
 */
public class MessageDB extends LitePalSupport {
    private int id;
    private String phoneNumber;
    private String messageTittle;//消息标题
    private int messageType;//1 安防，2环境，3推送
    private String messagePushTime;//推送时间
    @Column(unique = true)
    private String uniqueMessage;//(消息标题,消息类型,推送时间)作为整体约束，避免数据重复
    private String messageContent;//内容
    private String messageIconPath;//图片地址
    private int isRead = -1;//是否已经阅读 -1 未读  1已读

    public MessageDB() {
    }

    public MessageDB(String phoneNumber, String uniqueMessage, String messageContent, String messageIconPath) {
        this.phoneNumber = phoneNumber;
        this.uniqueMessage = uniqueMessage;
        this.messageContent = messageContent;
        this.messageIconPath = messageIconPath;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }

    public String getMessagePushTime() {
        return messagePushTime;
    }

    public void setMessagePushTime(String messagePushTime) {
        this.messagePushTime = messagePushTime;
    }

    public String getUniqueMessage() {
        return uniqueMessage;
    }

    public void setUniqueMessage(String uniqueMessage) {
        this.uniqueMessage = uniqueMessage;
    }

    public String getMessageTittle() {
        return messageTittle;
    }

    public void setMessageTittle(String messageTittle) {
        this.messageTittle = messageTittle;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public String getMessageIconPath() {
        return messageIconPath;
    }

    public void setMessageIconPath(String messageIconPath) {
        this.messageIconPath = messageIconPath;
    }

    public int isRead() {
        return isRead;
    }

    public void setRead(int read) {
        isRead = read;
    }

    @Override
    public String toString() {
        return "MessageDB{" +
                "id=" + id +
                ", messageType=" + messageType +
                ", messagePushTime='" + messagePushTime + '\'' +
                ", uniqueMessage='" + uniqueMessage + '\'' +
                ", messageTittle='" + messageTittle + '\'' +
                ", messageContent='" + messageContent + '\'' +
                ", messageIconPath='" + messageIconPath + '\'' +
                ", isRead=" + isRead +
                '}';
    }
}
