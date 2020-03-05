package cn.zhian.avater.netmodule.mode.responseBean;

import cn.zhian.avater.netmodule.mode.base.BaseResponse;

/**
 * Date：2020/3/2
 * Author:Avater
 * Description:
 */
public class AccountResponse extends BaseResponse {

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        private String avatar;
        private long createdTime;
        private String email;
        private boolean enabled;
        private String gatewayIp;
        private long id;
        private long customerId;
        private boolean isLocked;
        private String lastLoginIp;
        private long lastLoginTime;
        private int loginCount;
        private String loginDevices;
        private String mobile;
        private String nickname;
        private long updatedTime;
        private String username;
        private String weChat;
        private String weChatUnionId;

        public long getCustomerId() {
            return customerId;
        }

        public void setCustomerId(long customerId) {
            this.customerId = customerId;
        }

        public boolean isLocked() {
            return isLocked;
        }

        public void setLocked(boolean locked) {
            isLocked = locked;
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

        public boolean isIsLocked() {
            return isLocked;
        }

        public void setIsLocked(boolean isLocked) {
            this.isLocked = isLocked;
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

        public int getLoginCount() {
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

        @Override
        public String toString() {
            return "DataBean{" +
                    "avatar='" + avatar + '\'' +
                    ", createdTime=" + createdTime +
                    ", email='" + email + '\'' +
                    ", enabled=" + enabled +
                    ", gatewayIp='" + gatewayIp + '\'' +
                    ", id=" + id +
                    ", customerId=" + customerId +
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

    @Override
    public String toString() {
        return "AccountResponse{" +
                "data=" + data +
                ", seq='" + seq + '\'' +
                ", code=" + code +
                ", message='" + message + '\'' +
                ", success=" + success +
                '}';
    }
}
