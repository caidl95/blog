package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.entity.BaseEntity;

@Data
@TableName("user_role")
public class UserRole extends BaseEntity {

    @TableId("id")
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("role_id")
    private Integer roleId;


    public UserRole (Integer userId ,Integer roleId){
        this.userId = userId;
        this.roleId = roleId;
    }

}
