package wang.redbean.blog.common.entity.dto;

import lombok.Data;
import wang.redbean.blog.common.entity.param.ToolParam;
import wang.redbean.blog.core.base.entity.dto.BaseDto;

@Data
public class ToolDto extends BaseDto<ToolParam> {

    public ToolDto(ToolParam param) {
        super(param);
    }
}
