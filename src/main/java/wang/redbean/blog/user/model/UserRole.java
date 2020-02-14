package wang.redbean.blog.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.model.entity.BaseEntity;

@Data
@TableName("user_role")
public class UserRole extends BaseEntity {

    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("role_id")
    private Integer roleId;

    public UserRole(){}
    public UserRole (Integer userId ,Integer roleId){
        this.userId = userId;
        this.roleId = roleId;
    }

}
