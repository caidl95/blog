package wang.redbean.blog.user.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 权限实体类
 */
@Data
@TableName(value = "user_group")
public class UserGroup extends BaseEntity {

    @TableId(value = "group_id",type = IdType.AUTO)
    private Integer groupId;//分组ID

    @TableField(value = "user_id")
    private Integer userId;//用户ID

    @TableField(value = "rights_type")
    private Integer rightsType;//用户权限

}
