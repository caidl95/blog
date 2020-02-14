package wang.redbean.blog.common.model.dto;

import lombok.Data;
import wang.redbean.blog.common.model.param.ToolParam;
import wang.redbean.blog.core.base.model.dto.BaseDto;

@Data
public class ToolDto extends BaseDto<ToolParam> {

    public ToolDto(ToolParam param) {
        super(param);
    }
}
