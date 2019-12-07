package wang.redbean.blog.user.entity;


import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;


/**
 * 登录日志实体类
 */
@Data
public class UserLogin extends BaseEntity {

    private Integer loginId;//登录日志ID

    private Integer userId;//用户ID

    private String loginIp;//登录ip

}
