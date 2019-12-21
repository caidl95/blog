package wang.redbean.blog.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.entity.BaseEntity;


/**
 * 登录日志实体类
 */
@Data
@TableName(value = "user_login")
public class UserLogin extends BaseEntity {

    @TableId(value = "login_id",type = IdType.AUTO)
    private Integer loginId;//登录日志ID

    @TableField(value = "user_id")
    private Integer userId;//用户ID

    @TableField(value = "login_ip")
    private String loginIp;//登录ip

}
