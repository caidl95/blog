package wang.redbean.blog.user.entity.vo;

import lombok.Data;
import wang.redbean.blog.user.entity.UserRights;


@Data
public class UserGroupVo extends UserRights {

    private Integer userId;//所属用户

}
