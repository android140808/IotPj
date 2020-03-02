package cn.zhian.avater.netmodule.mode.requestBean;

import cn.zhian.avater.netmodule.mode.base.BaseRequest;

/**
 * Date：2020/3/2
 * Author:Avater
 * Description:
 */
public class AccountRequest extends BaseRequest {
    private String avatar;
    private long createdTime;
    private String email;
    private boolean enabled;
    private String gatewayIp;
    private long id;
    private boolean isLocked;
    private String lastLoginIp;
    private long lastLoginTime;
    private long loginCount;
    private String loginDevices;
    private String mobile;
    private String nickname;
    private long updatedTime;
    private String username;
    private String weChat;
    private String weChatUnionId;

    public AccountRequest() {
    }

    public AccountRequest(String avatar, long createdTime, String email, boolean enabled,
                          String gatewayIp, long id, boolean isLocked, String lastLoginIp,
                          long lastLoginTime, long loginCount, String loginDevices, String mobile,
                          String nickname, long updatedTime, String username, String weChat, String weChatUnionId) {

        this.avatar = avatar;
        this.createdTime = createdTime;
        this.email = email;
        this.enabled = enabled;
        this.gatewayIp = gatewayIp;
        this.id = id;
        this.isLocked = isLocked;
        this.lastLoginIp = lastLoginIp;
        this.lastLoginTime = lastLoginTime;
        this.loginCount = loginCount;
        this.loginDevices = loginDevices;
        this.mobile = mobile;
        this.nickname = nickname;
        this.updatedTime = updatedTime;
        this.username = username;
        this.weChat = weChat;
        this.weChatUnionId = weChatUnionId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getGatewayIp() {
        return gatewayIp;
    }

    public void setGatewayIp(String gatewayIp) {
        this.gatewayIp = gatewayIp;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public boolean isLocked() {
        return isLocked;
    }

    public void setLocked(boolean locked) {
        isLocked = locked;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public long getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(long lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public long getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(long loginCount) {
        this.loginCount = loginCount;
    }

    public String getLoginDevices() {
        return loginDevices;
    }

    public void setLoginDevices(String loginDevices) {
        this.loginDevices = loginDevices;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public long getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(long updatedTime) {
        this.updatedTime = updatedTime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getWeChatUnionId() {
        return weChatUnionId;
    }

    public void setWeChatUnionId(String weChatUnionId) {
        this.weChatUnionId = weChatUnionId;
    }

    @Override
    public String toString() {
        return "AccountRequest{" +
                "avatar='" + avatar + '\'' +
                ", createdTime=" + createdTime +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", gatewayIp='" + gatewayIp + '\'' +
                ", id=" + id +
                ", isLocked=" + isLocked +
                ", lastLoginIp='" + lastLoginIp + '\'' +
                ", lastLoginTime=" + lastLoginTime +
                ", loginCount=" + loginCount +
                ", loginDevices='" + loginDevices + '\'' +
                ", mobile='" + mobile + '\'' +
                ", nickname='" + nickname + '\'' +
                ", updatedTime=" + updatedTime +
                ", username='" + username + '\'' +
                ", weChat='" + weChat + '\'' +
                ", weChatUnionId='" + weChatUnionId + '\'' +
                '}';
    }
}
