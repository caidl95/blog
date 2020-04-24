package wang.redbean.blog.article.model.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import wang.redbean.blog.base.entity.BaseEntity;

/**
 * 类别
 */
@Getter
@Setter
@TableName(value = "category")
public class Category extends BaseEntity {

    @TableField(value = "parent_id")
    private Long parentId;// 父类别id当id=0时说明是根节点,一级类别',

    @TableField(value = "name")
    private String name;// '类别名称',

    @TableField(value = "type")
    private Integer type;//'类目编号

    @TableField(value = "status")
    private Integer status;// '类别状态0-正常,1-已废弃',


}
