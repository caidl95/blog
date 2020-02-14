package wang.redbean.blog.common.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import wang.redbean.blog.core.base.model.entity.BaseEntity;

@Data
@TableName(value = "common_tool")
public class Tool extends BaseEntity {

    @TableId(value = "tool_id",type = IdType.AUTO)
    private Integer toolId;//常用工具ID

    @TableField(value = "user_id")
    private Integer userId;//用户id

    @TableField(value = "tool_name")
    private String toolName;//工具名称

    @TableField(value = "tool_explain")
    private String toolExplain;//工具说明

    @TableField(value = "tool_url")
    private String toolUrl;//存放地址

    @TableField(value = "category_type")
    private Integer categoryType;//分类

}
