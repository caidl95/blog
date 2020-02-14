package wang.redbean.blog.common.model.vo;

import lombok.Data;
import wang.redbean.blog.common.model.Tool;

@Data
public class ToolVo extends Tool {

    private String userNickname;

    private String categoryTypeName;

}
