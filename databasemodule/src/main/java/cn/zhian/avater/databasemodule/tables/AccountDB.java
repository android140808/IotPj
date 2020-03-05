package cn.zhian.avater.databasemodule.tables;

import org.litepal.annotation.Column;
import org.litepal.crud.LitePalSupport;

/**
 * @Author: wangweida
 * @CreateDate: 2019-12-21 9:30
 * @Description: 用户数据表
 */
public class AccountDB extends LitePalSupport {
    private long id;
    //唯一约束
    private String avatar;
    private long createdTime;
    private String email;
    private boolean enabled;
    private String gatewayIp;
    private long accountId;//对应id
    private boolean isLocked;
    private String lastLoginIp;
    private long lastLoginTime;
    private long loginCount;
    private String loginDevices;
    @Column(unique = true)
    private String mobile;
    private String nickname;
    private long updatedTime;
    private String username;
    private String weChat;
    private String weChatUnionId;

    public AccountDB() {
    }

    public AccountDB(String avatar, long createdTime, String email, boolean enabled, String gatewayIp,
                     long accountId, boolean isLocked, String lastLoginIp, long lastLoginTime, int loginCount,
                     String loginDevices, String mobile, String nickname, long updatedTime, String username,
                     String weChat, String weChatUnionId) {

        this.avatar = avatar;
        this.createdTime = createdTime;
        this.email = email;
        this.enabled = enabled;
        this.gatewayIp = gatewayIp;
        this.accountId = accountId;
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

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
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

    public void setLoginCount(int loginCount) {
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
}
