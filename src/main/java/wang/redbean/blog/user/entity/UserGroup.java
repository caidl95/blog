package wang.redbean.blog.user.entity;

import wang.redbean.blog.common.base.entity.BaseEntity;

import javax.xml.crypto.Data;
import java.util.Date;

public class UserGroup extends BaseEntity {

    private Integer groupId;//分组ID

    private Integer userId;//用户ID

    private Integer rightsType;//用户权限

    public UserGroup() {
    }

    public UserGroup(Data createTime, Date updateTime, Integer groupId, Integer userId, Integer rightsType) {
        super(createTime, updateTime);
        this.groupId = groupId;
        this.userId = userId;
        this.rightsType = rightsType;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRightsType() {
        return rightsType;
    }

    public void setRightsType(Integer rightsType) {
        this.rightsType = rightsType;
    }
}
