package wang.redbean.blog.user.model.dto;

import lombok.Data;
import wang.redbean.blog.core.base.model.dto.BaseDto;
import wang.redbean.blog.user.model.param.UserLoginParam;

@Data
public class UserLoginDto extends BaseDto<UserLoginParam> {

    public UserLoginDto(UserLoginParam param) {
        super(param);
    }
}
