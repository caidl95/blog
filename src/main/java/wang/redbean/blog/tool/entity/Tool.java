package wang.redbean.blog.tool.entity;

import lombok.Data;
import wang.redbean.blog.common.base.entity.BaseEntity;

@Data
public class Tool extends BaseEntity {

    private Integer toolId;//常用工具ID

    private Integer toolUserId;//用户id

    private String toolName;//工具名称

    private String toolExplain;//工具说明

    private String toolUrl;//存放地址

}
