package wang.redbean.blog.common.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.entity.BaseEntity;
/**
 * 类别
 */
@Data
@TableName(value = "common_category")
public class Category extends BaseEntity {

    @TableId(value = "category_id",type = IdType.AUTO)
    private Integer categoryId ;//'类别Id',

    @TableField(value = "parent_id")
    private Integer parentId;// 父类别id当id=0时说明是根节点,一级类别',

    @TableField(value = "category_name")
    private String categoryName;// '类别名称',

    @TableField(value = "category_type")
    private Integer categoryType;//'类目编号

    @TableField(value = "category_status")
    private Integer categoryStatus;// '类别状态0-正常,1-已废弃',


}
