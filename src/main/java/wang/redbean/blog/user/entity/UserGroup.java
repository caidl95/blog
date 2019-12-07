package wang.redbean.blog.user.entity;


import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 权限实体类
 */
@Data
public class UserGroup extends BaseEntity {

    private Integer groupId;//分组ID

    private Integer userId;//用户ID

    private Integer rightsType;//用户权限

}
