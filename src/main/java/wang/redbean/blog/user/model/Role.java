package wang.redbean.blog.user.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.model.entity.BaseEntity;

@Data
@TableName("role")
public class Role extends BaseEntity {

    @TableId(value = "id" ,type = IdType.AUTO)
    private Integer id;

    @TableField("name")
    private String name;

}
