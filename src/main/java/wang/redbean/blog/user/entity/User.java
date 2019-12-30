package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.entity.BaseEntity;

import java.util.List;

@Data
@TableName("user")
public class User extends BaseEntity {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    private List<Role> roles;

}
