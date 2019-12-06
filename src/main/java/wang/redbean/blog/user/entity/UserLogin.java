package wang.redbean.blog.user.entity;

import wang.redbean.blog.common.base.entity.BaseEntity;
import javax.xml.crypto.Data;
import java.util.Date;

/**
 * 登录日志
 */
public class UserLogin extends BaseEntity {

    private Integer loginId;//登录日志ID

    private Integer userId;//用户ID

    private String loginIp;//登录ip

    public UserLogin() {
    }

    public UserLogin(Data createTime, Date updateTime, Integer loginId, Integer userId, String loginIp) {
        super(createTime, updateTime);
        this.loginId = loginId;
        this.userId = userId;
        this.loginIp = loginIp;
    }

    public Integer getLoginId() {
        return loginId;
    }

    public void setLoginId(Integer loginId) {
        this.loginId = loginId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }
}
