package wang.redbean.blog.user.entity.dto;

import lombok.Data;
import wang.redbean.blog.core.base.entity.dto.BaseDto;
import wang.redbean.blog.user.entity.param.UserLoginParam;

@Data
public class UserLoginDto extends BaseDto<UserLoginParam> {

    public UserLoginDto(UserLoginParam param) {
        super(param);
    }
}
