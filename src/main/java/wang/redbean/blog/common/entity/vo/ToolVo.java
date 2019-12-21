package wang.redbean.blog.common.entity.vo;

import lombok.Data;
import wang.redbean.blog.common.entity.Tool;

@Data
public class ToolVo extends Tool {

    private String userNickname;

    private String categoryTypeName;

}
