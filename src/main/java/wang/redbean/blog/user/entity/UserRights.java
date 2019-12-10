package wang.redbean.blog.user.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

/**
 * 用户权限实体类
 */
@Data
@TableName(value = "user_rights")
public class UserRights extends BaseEntity {

    @TableId(value = "rights_id",type = IdType.AUTO)
    private Integer rightsId;//权限ID

    @TableField(value = "rights_name")
    private String rightsName;//权限名字

    @TableField(value = "rights_type")
    private Integer rightsType;//权限编号

}
